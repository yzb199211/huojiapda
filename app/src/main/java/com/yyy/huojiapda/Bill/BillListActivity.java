package com.yyy.huojiapda.Bill;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
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
    int formid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);
        ButterKnife.bind(this);
        preferencesHelper = new SharedPreferencesHelper(this, getString(R.string.preferenceCache));
        init();
    }

    private void init() {
        getDefaultData();
        initView();
        getData();
    }

    private void getDefaultData() {
        userid = (String) preferencesHelper.getSharedPreference("userid", "");
        url = (String) preferencesHelper.getSharedPreference("address", "") + NetConfig.server + NetConfig.ReportHandler_Method;
        getIntentData();
    }

    private void getIntentData() {
        formid = getIntent().getIntExtra("formid", 0);
    }

    private void initView() {
        ivBack.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(getString(R.string.add));
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

    private void initData(String string) throws JSONException ,NullPointerException{
        JSONObject jsonObject = new JSONObject(string);
        if (jsonObject.getBoolean("success")) {
            initInfo(jsonObject.optString("info"));
        } else {
            LoadingFinish(jsonObject.optString("message"));
        }
    }

    private void initInfo(String info) throws NullPointerException{


    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                break;
        }
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
