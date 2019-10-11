package com.yyy.huojiapda.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.yyy.huojiapda.Bill.BillListActivity;
import com.yyy.huojiapda.R;
import com.yyy.huojiapda.interfaces.OnItemClickListener;
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

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;

    SharedPreferencesHelper preferencesHelper;

    List<MainMenu.MenusBean.ChildMenusBean> menus;
    MainMenuAdapter menuAdapter;

    String userid;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        menus = new ArrayList<>();
    }


    private void initView() {
        tvTitle.setText(getString(R.string.title_main));
    }

    private void getDefaultData() {
        userid = (String) preferencesHelper.getSharedPreference("userid", "");
        url = (String) preferencesHelper.getSharedPreference("address", "") + NetConfig.server + NetConfig.ReportHandler_Method;
    }

    private List<NetParams> getParams() {
        List<NetParams> params = new ArrayList<>();
        params.add(new NetParams("userid", userid));
        params.add(new NetParams("otype", Otype.mainMenu));
        return params;
    }

    private void getData() {
        LoadingDialog.showDialogForLoading(this);
        new NetUtil(getParams(), url, new ResponseListener() {
            @Override
            public void onSuccess(String string) {
                try {
                    initData(string);
                } catch (Exception e) {
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

    private void initData(String string) throws Exception {
        MainMenu mainMenu = new Gson().fromJson(string, MainMenu.class);
        if (mainMenu.isSuccess()) {
            initListData(mainMenu.getMenus());
        } else {
            LoadingFinish(mainMenu.getMessage());
        }
    }

    private void initListData(List<MainMenu.MenusBean> menus) throws Exception {
        setListData(menus);
        if (this.menus.size() > 0) {
            setList();
        } else {
            LoadingFinish(getString(R.string.error_loading_fail));
        }
    }

    private void setListData(List<MainMenu.MenusBean> menus) throws Exception {
        for (int i = 0; i < menus.size(); i++) {
            this.menus.addAll(menus.get(i).getMenus());
        }
    }

    private void setList() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    initListAdapter();
                    rvMenu.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
                    rvMenu.setAdapter(menuAdapter);
                    setViewVisibility(View.GONE, View.VISIBLE);
                    LoadingFinish("");
                } catch (Exception e) {
                    e.printStackTrace();
                    LoadingFinish(getString(R.string.error_view));
                }

            }
        });


    }

    private void initListAdapter() {
        menuAdapter = new MainMenuAdapter(this, menus);
        menuAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goActivity(menus.get(position).formId());
            }
        });
    }

    private void goActivity(int formId) {
        startActivity(new Intent().putExtra("formid", formId).setClass(this, BillListActivity.class));
    }

    @OnClick({R.id.iv_back, R.id.tv_empty})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.tv_empty:
                getData();
                break;
        }
    }

    private void LoadingFinish(String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (StringUtil.isNotEmpty(msg)) {
                    Toast(msg);
                    setViewVisibility(View.VISIBLE, View.GONE);
                }
                LoadingDialog.cancelDialogForLoading();

            }
        });
    }

    private void Toast(String msg) {
        Toasts.showShort(this, msg);
    }

    private void setViewVisibility(int tv, int rv) {
        tvEmpty.setVisibility(tv);
        rvMenu.setVisibility(rv);
    }
}
