package com.yyy.huojiapda.Bill;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.yyy.huojiapda.R;
import com.yyy.huojiapda.interfaces.OnLookUpListener;
import com.yyy.huojiapda.net.NetConfig;
import com.yyy.huojiapda.net.Otype;
import com.yyy.pda.dialog.LoadingDialog;
import com.yyy.pda.interfaces.ResponseListener;
import com.yyy.pda.net.NetParams;
import com.yyy.pda.net.NetUtil;
import com.yyy.pda.util.PxUtil;
import com.yyy.pda.util.SharedPreferencesHelper;
import com.yyy.pda.util.StringUtil;
import com.yyy.pda.util.Toasts;
import com.yyy.pda.view.Configure.ConfigureInfoView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailView extends FrameLayout {
    private static final String TAG = "BillDetailView";
    Context context;

    List<BillDetailInfo.Info.FormColumns> columns;
    List<BillDetailInfoView> views;

    SharedPreferencesHelper preferencesHelper;

    int w;
    int h;
    int itemWidth;
    int padding;
    int paddingMiddle;
    int paddingleft;
    int paddingTop;
    int paddingRight;

    String url;


    public BillDetailView(@NonNull Context context) {
        this(context, null);
    }

    public BillDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        preferencesHelper = new SharedPreferencesHelper(context, context.getString(R.string.preferenceCache));

    }

    private void init() {
        initList();
        getDefaultData();
        initView();
        initData();

    }

    private void getDefaultData() {
        url = (String) preferencesHelper.getSharedPreference("address", "") + NetConfig.server + NetConfig.ReportHandler_Method;
    }

    private void initList() {
        views = new ArrayList<>();
    }

    private void initView() {
        padding = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
        paddingMiddle = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
        paddingleft = context.getResources().getDimensionPixelOffset(R.dimen.dp_20);
        paddingTop = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
        paddingRight = context.getResources().getDimensionPixelOffset(R.dimen.dp_20);
        setPadding(padding, padding, padding, padding);
        itemWidth = PxUtil.getWidth(context) - padding * 2;

    }

    private void getChildParams(BillDetailInfo.Info.FormColumns column) {


    }

    private void initData() {

        for (int i = 0; i < columns.size(); i++) {

            BillDetailInfo.Info.FormColumns column = columns.get(i);
            int row = -1;
            if (row == -1)
                row = column.getIRowNum();
            if (column.getIHide() != 0) {

                LinearLayout.LayoutParams params = (i + 1 < columns.size() && row != columns.get(i + 1).getIRowNum())
                        ? new LinearLayout.LayoutParams((int) (itemWidth - w), ViewGroup.LayoutParams.WRAP_CONTENT)
                        : new LinearLayout.LayoutParams((int) (itemWidth * (column.getPercent())), ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(w, h, 0, 0);

                getChildParams(column);
                BillDetailInfoView infoView = setView(column);
                setPaddings(infoView, row, i);
                setListener(infoView, column);
                addView(infoView);
                views.add(infoView);
            }
        }
    }

    private void setListener(BillDetailInfoView infoView, BillDetailInfo.Info.FormColumns column) {
        if (StringUtil.isNotEmpty(column.getLookup())) {
            infoView.setOnLookUpListener(new OnLookUpListener() {
                @Override
                public void onLookUp(TextView textView) {
                    initLookup(column.getLookup());
                }
            });
        }

    }

    private void initLookup(String lookup) {
        try {
            BillDetailInfo.Info.MainLookup lookupBean = new Gson().fromJson(lookup, BillDetailInfo.Info.MainLookup.class);
            String[] matchFields = spiltMacthFields(lookupBean.getSFixFilters());
            List<String> fields = getFields(matchFields);
            getLookupData(getFilter(fields, lookupBean.getSFixFilters()), lookupBean.getSLookUpName(), lookupBean.getSMatchFields());
//            getFilter(fields, lookupBean.getSChangeFilters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<NetParams> getLookupParams(String filter, String lookupName) {
        List<NetParams> params = new ArrayList<>();
        params.add(new NetParams("otype", Otype.lookup));
        params.add(new NetParams("userid", (int) preferencesHelper.getSharedPreference("userid", "0") + ""));
        params.add(new NetParams("page", "1"));
        params.add(new NetParams("pageSize", "1000"));
        params.add(new NetParams("filters", filter));
        params.add(new NetParams("lookupName", lookupName));
        return params;
    }

    private void getLookupData(String filter, String lookupName, String sMatchFields) {
        LoadingDialog.showDialogForLoading(context);
        new NetUtil(getLookupParams(filter, lookupName), url, new ResponseListener() {
            @Override
            public void onSuccess(String string) {
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    judgeSuccess(jsonObject, sMatchFields);
                } catch (JSONException e) {
                    e.printStackTrace();
                    FinishLoading(context.getString(R.string.error_json));
                }
            }

            @Override
            public void onFail(IOException e) {
                e.printStackTrace();
                FinishLoading(e.getMessage());
            }
        });
    }

    private void judgeSuccess(JSONObject jsonObject, String sMatchFields) throws JSONException {
        if (jsonObject.optBoolean("success")) {
            JSONObject fields = jsonObject.optJSONObject("data");
            String returnFields = fields.optString("sReturnField");
            String displayFields = fields.optString("sDisplayField");
            initLookUpData(jsonObject.optString("tables"), returnFields, displayFields, sMatchFields);
        } else {
            FinishLoading(jsonObject.optString("message"));
        }
    }

    private void initLookUpData(String tables, String returnFields, String displayFields, String sMatchFields) throws JSONException {
        JSONObject jsonObject = new JSONObject(tables);
        JSONArray jsonArray = jsonObject.optJSONArray("LookupData");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            item.put("id", jsonObject.opt(returnFields));
            item.put("name", jsonObject.optString(displayFields));
            item.put("link_id", sMatchFields);
        }

    }


    private String[] spiltMacthFields(String sMatchFields) {
        return sMatchFields.split("#");
    }

    private List<String> getFields(String[] matchFields) {
        List<String> fields = new ArrayList<>();
        for (int i = 0; i < matchFields.length; i++) {
            if (i % 2 != 0)
                fields.add(matchFields[i]);
        }
        return fields;
    }

    private String getFilter(List<String> fields, String sChangeFilters) {
        sChangeFilters.replaceAll("\\{userid}", (int) preferencesHelper.getSharedPreference("userid", 0) + "");
        for (String field : fields) {
            for (BillDetailInfoView view : views) {
                String tag = (String) view.getTag();
                if (tag.equals(field)) {
                    sChangeFilters = sChangeFilters.replace("#" + field + "#", view.getText());
                    break;
                }
            }
        }
        return sChangeFilters;
    }


    private BillDetailInfoView setView(BillDetailInfo.Info.FormColumns column) {
        BillDetailInfoView infoView = new BillDetailInfoView(context);
        infoView.setInfo(column);
        return infoView;
    }

    private void setPaddings(BillDetailInfoView rivItem, int row, int i) {
        if (i + 1 < columns.size() && row == columns.get(i + 1).getIRowNum()) {
            rivItem.setPadding(paddingleft, paddingTop, paddingMiddle, 0);

        } else if ((i + 1 < columns.size() && row != columns.get(i + 1).getIRowNum())) {
            rivItem.setPadding(paddingleft, paddingTop, paddingRight, 0);

        } else if (i + 1 == columns.size()) {
            rivItem.setPadding(paddingleft, paddingTop, paddingRight, 0);
//            Log.e(TAG, i + "c");
        } else if ((i + 1 < columns.size() && row != columns.get(i + 1).getIRowNum())) {
            rivItem.setPadding(paddingMiddle, paddingTop, paddingRight, 0);

        } else {
            rivItem.setPadding(paddingMiddle, paddingTop, paddingMiddle, 0);
        }
    }


    public void setColumns(List<BillDetailInfo.Info.FormColumns> columns, Activity activity) {
        this.columns = columns;
        init();
    }


    private void FinishLoading(@Nullable String msg) {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LoadingDialog.cancelDialogForLoading();
                if (StringUtil.isNotEmpty(msg))
                    Toasts.showShort(context, msg);
            }
        });
    }
}
