package com.yyy.huojiapda.Bill;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yyy.huojiapda.R;
import com.yyy.huojiapda.net.NetConfig;
import com.yyy.huojiapda.net.Otype;
import com.yyy.pda.dialog.LoadingDialog;
import com.yyy.pda.interfaces.ResponseListener;
import com.yyy.pda.list.RecyclerViewDivider;
import com.yyy.pda.net.NetParams;
import com.yyy.pda.net.NetUtil;
import com.yyy.pda.util.SharedPreferencesHelper;
import com.yyy.pda.util.StringUtil;
import com.yyy.pda.util.Toasts;
import com.yyy.pda.view.Configure.ConfigureInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BillListActivity extends AppCompatActivity {
    private static final String TAG = "BillListActivity";
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.rv_bill)
    XRecyclerView rvBill;

    SharedPreferencesHelper preferencesHelper;

    String userid;
    String url;
    String title;
    int formid;

    List<BillInfo.ReportColumn2> columns;
    List<List<ConfigureInfo>> items;

    BillListAdapter mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);
        ButterKnife.bind(this);
        preferencesHelper = new SharedPreferencesHelper(this, getString(R.string.preferenceCache));
        init();
    }

    private void init() {
        initList();
        getDefaultData();
        initView();
        getData();
    }

    private void initList() {
        columns = new ArrayList<>();
        items = new ArrayList<>();
    }

    private void getDefaultData() {
        userid = (String) preferencesHelper.getSharedPreference("userid", "");
        url = (String) preferencesHelper.getSharedPreference("address", "") + NetConfig.server + NetConfig.ReportHandler_Method;
        getIntentData();
    }

    private void getIntentData() {
        formid = getIntent().getIntExtra("formid", 0);
        title = getIntent().getStringExtra("title");
    }

    private void initView() {
        ivBack.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(getString(R.string.add));
        tvTitle.setText(title);
        initListView();


    }

    private void initListView() {
        rvBill.setLayoutManager(getManager());
        rvBill.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        rvBill.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        rvBill.setArrowImageView(R.mipmap.iconfont_downgrey);
        rvBill.getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        rvBill.setLoadingMoreEnabled(false);
        rvBill.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.VERTICAL));
    }

    private LinearLayoutManager getManager() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        return manager;
    }

    private List<NetParams> getParams() {
        List<NetParams> params = new ArrayList<>();
        params.add(new NetParams("otype", Otype.billList));
        params.add(new NetParams("userid", userid));
        params.add(new NetParams("iFormID", formid + ""));
        return params;
    }

    private void getData() {
        LoadingDialog.showDialogForLoading(this);
        new NetUtil(getParams(), url, new ResponseListener() {
            @Override
            public void onSuccess(String string) {
                try {
                    initData(string);

                } catch (JSONException e) {
                    e.printStackTrace();
                    LoadingFinish(getString(R.string.error_json));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    LoadingFinish(getString(R.string.error_data));
                }
            }

            @Override
            public void onFail(IOException e) {
                e.printStackTrace();
                LoadingFinish(getString(R.string.error_loading_fail));
            }
        });
    }

    private void initData(String string) throws JSONException, NullPointerException {
        JSONObject jsonObject = new JSONObject(string);
        if (jsonObject.getBoolean("success")) {
            initInfo(jsonObject.optString("info"));
            Log.e("data", jsonObject.optString("data"));
            getListData(jsonObject.getJSONArray("data"));
        } else {
            LoadingFinish(jsonObject.optString("message"));
        }
        setView();
    }

    private void setView() {
        if (items.size() > 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Refresh();
                    LoadingFinish("");
                }
            });
        } else {
            LoadingFinish(getString(R.string.empty_data));
        }

    }

    private void Refresh() throws NullPointerException {
        if (mAdpater == null) {
            mAdpater = new BillListAdapter(this, items);
            rvBill.setAdapter(mAdpater);
            setLoaderListener();
        } else {
            mAdpater.notifyDataSetChanged();
        }
    }

    private void setLoaderListener() {
        rvBill.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                items.clear();
                mAdpater.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void initInfo(String info) throws NullPointerException {
        columns.addAll(new Gson().fromJson(info, BillInfo.class).getReportColumns2());
    }

    private List<List<ConfigureInfo>> getListData(JSONArray data) throws NullPointerException, JSONException {
        for (int i = 0; i < data.length(); i++) {
            List<ConfigureInfo> configureInfos = new ArrayList<>();
            getConfigureInfo(configureInfos, data.getJSONObject(i));
            items.add(configureInfos);
        }
        return items;
    }

    private void getConfigureInfo(List<ConfigureInfo> configureInfos, JSONObject jsonObject) throws NullPointerException {
        for (int i = 0; i < columns.size(); i++) {
            ConfigureInfo info = new ConfigureInfo();
            BillInfo.ReportColumn2 column = columns.get(i);

            info.setSingleLine(true);
            info.setWidthPercent(StringUtil.isPercent(column.getIProportio()));
            info.setRow(column.getISerial());
            info.setTitleSize(getInfoTitleSize(column.getSNameFontSize()));
            info.setTitle(column.getSFieldsDisplayName());
            info.setTitleBold((column.getINameFontBold() == 1) ? true : false);
            if (StringUtil.isColor(column.getSNameFontColor()))
                info.setTitleColor(Color.parseColor(column.getSNameFontColor()));

            info.setContentSize(getInfoContentSize(column.getSValueFontSize()));
            info.setContent(jsonObject.optString(column.getSFieldsName()));
            info.setContentBold((column.getIValueFontBold() == 1) ? true : false);
            if (StringUtil.isColor(column.getSValueFontColor()))
                info.setTitleColor(Color.parseColor(column.getSValueFontColor()));
            configureInfos.add(info);
        }
    }

    private int getInfoContentSize(String sValueFontSize) {
        if (StringUtil.isNotEmpty(sValueFontSize) && StringUtil.isInteger(sValueFontSize)) {
            return Integer.parseInt(sValueFontSize);
        } else {
            return 0;
        }
    }

    private int getInfoTitleSize(String sNameFontSize) {
        if (StringUtil.isNotEmpty(sNameFontSize) && StringUtil.isInteger(sNameFontSize)) {
            return Integer.parseInt(sNameFontSize);
        } else {
            return 0;
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                goDetail(0);
                break;
        }
    }

    private void goDetail(int key) {
        startActivity(new Intent()
                .setClass(this, BillDetailActivity.class)
                .putExtra("formid", formid)
                .putExtra("title", title)
                .putExtra("key", key));
    }

    private void LoadingFinish(String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (StringUtil.isNotEmpty(msg)) {
                    Toast(msg);
                }
                LoadingDialog.cancelDialogForLoading();

            }
        });
    }

    private void Toast(String msg) {
        Toasts.showShort(this, msg);
    }
}
