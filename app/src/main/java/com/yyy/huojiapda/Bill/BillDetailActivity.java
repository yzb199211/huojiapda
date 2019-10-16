package com.yyy.huojiapda.Bill;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.yyy.huojiapda.R;
import com.yyy.huojiapda.net.NetConfig;
import com.yyy.huojiapda.net.Otype;
import com.yyy.pda.dialog.LoadingDialog;
import com.yyy.pda.interfaces.ResponseListener;
import com.yyy.pda.net.NetParams;
import com.yyy.pda.net.NetUtil;
import com.yyy.pda.util.SharedPreferencesHelper;
import com.yyy.pda.util.StringUtil;
import com.yyy.pda.util.Toasts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BillDetailActivity extends AppCompatActivity {
    private static final String TAG = "BillDetailActivity";

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.fl_content)
    FrameLayout flContent;

    SharedPreferencesHelper preferencesHelper;

    List<BillDetailInfo.Info.FormColumns> mainColumns;
    List<BillDetailInfo.Info.FormColumns> childColumns;
    List<BillDetailInfo.Info.MainLookup> mainLookup;
    List<BillDetailInfo.Info.ChildLookup> childLookup;

    String userid;
    String url;
    String title;

    int formid;
    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
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
        mainColumns = new ArrayList<>();
        childColumns = new ArrayList<>();
        mainLookup = new ArrayList<>();
        childLookup = new ArrayList<>();
    }

    private void getDefaultData() {
        userid = (String) preferencesHelper.getSharedPreference("userid", "");
        url = (String) preferencesHelper.getSharedPreference("address", "") + NetConfig.server + NetConfig.ReportHandler_Method;
        getIntentData();
    }

    private void getIntentData() {
        formid = getIntent().getIntExtra("formid", 0);
        title = getIntent().getStringExtra("title");
        key = getIntent().getIntExtra("key", 0);
    }

    private void initView() {
        ivBack.setVisibility(View.GONE);
        tvTitle.setText(getIntent().getStringExtra(""));
    }

    private List<NetParams> getParams() {
        List<NetParams> params = new ArrayList<>();
        params.add(new NetParams("userid", userid));
        params.add(new NetParams("iFormID", formid + ""));
        params.add(new NetParams("key", key + ""));
        params.add(new NetParams("otype", Otype.billDetailInfo));
        return params;
    }

    private void getData() {
        new NetUtil(getParams(), url, new ResponseListener() {
            @Override
            public void onSuccess(String string) {
                try {
                    BillDetailInfo info = new Gson().fromJson(string, BillDetailInfo.class);
                    initData(info);
                } catch (NullPointerException e) {
                    LoadingFinish(getString(R.string.error_null_pointer));
                }

            }

            @Override
            public void onFail(IOException e) {
                e.printStackTrace();
                LoadingFinish(getString(R.string.error_loading_fail));
            }
        });
    }

    private void initData(BillDetailInfo info) throws NullPointerException {
        if (info.isSuccess()) {
            getKey(info.getKey());
            getColumns(info.getInfo().getFormColumns());
            getMainLookup(info.getInfo().getMainLookup());
            getChildLookup(info.getInfo().getChildLookup());
            setView();
        } else {
            LoadingFinish(info.getMessage());
        }
    }


    private void getKey(int key) {
        this.key = this.key == 0 ? key : this.key;
    }

    private void getColumns(List<BillDetailInfo.Info.FormColumns> formColumns) {
        for (BillDetailInfo.Info.FormColumns column : formColumns) {
            if (column.getIDetail() == 0) {
                mainColumns.add(column);
            } else {
                childColumns.add(column);
            }
        }
    }

    private void getMainLookup(List<BillDetailInfo.Info.MainLookup> mainLookup) {
        if (mainLookup != null && mainLookup.size() > 0) {
            this.mainLookup.addAll(mainLookup);
            initMainColumnLookup();
        }
    }

    private void getChildLookup(List<BillDetailInfo.Info.ChildLookup> childLookup) {
        if (childLookup != null && childLookup.size() > 0) {
            this.childLookup.addAll(childLookup);
        }
    }

    private void initMainColumnLookup() {
        for (int i = 0; i < mainLookup.size(); i++) {
//            mainLookup.get(i).getSFieldName();
            setMainColumnsLookup(mainLookup.get(i));
        }
    }

    private void setMainColumnsLookup(BillDetailInfo.Info.MainLookup mainLookup) {
        for (int i = 0; i < mainColumns.size(); i++) {
            if (mainLookup.getSFieldName().equals(mainColumns.get(i).getSFieldsName())) {
                mainColumns.get(i).setLookup(new Gson().toJson(mainLookup));
                break;
            }
        }

    }

    private void setView() {

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
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
