package com.yyy.huojiapda.Bill;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yyy.huojiapda.R;
import com.yyy.pda.util.StringUtil;


public class BillDetailInfoView extends LinearLayout {
    Context context;
    BillDetailInfo.Info.FormColumns info;

    private TextView tvTitle;
    private TextView tvContent;
    private EditText etContent;
    private ImageView ivLookup;
    private Switch switchView;

    int titleColor;
    int contentColor;
    boolean titleBold;
    boolean contentBold;
    boolean singleLine;

    String fieldType;
    String text;

    int viewType;

    public BillDetailInfoView(Context context) {
        this(context, null);
    }

    public BillDetailInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.item_bill_detail_info, this, true);
        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_title);
        etContent = findViewById(R.id.et_content);
        switchView = findViewById(R.id.switch_view);

    }

    public void setInfo(BillDetailInfo.Info.FormColumns info) {
        this.info = info;
        initView();
    }

    public void setText(String text) {
        this.text = text;
    }

    private void initView() {
        if (info.getSFieldsType().toLowerCase().equals("bool")) {
            setSwitch();
        } else if (info.getIReadOnly() == 0) {
            setEdit();
        } else {
            setTv();
        }
    }

    private void setEdit() {
        etContent.setVisibility(VISIBLE);
        tvContent.setVisibility(GONE);
        switchView.setVisibility(GONE);
    }

    private void setTv() {
        etContent.setVisibility(GONE);
        tvContent.setVisibility(VISIBLE);
        switchView.setVisibility(GONE);
        setTvConfig();
    }


    private void setSwitch() {
        etContent.setVisibility(GONE);
        tvContent.setVisibility(GONE);
        switchView.setVisibility(VISIBLE);
    }

    private void setTvConfig() {

    }

    private void setLimit(String text) {
        switch (info.getSFieldsType().toLowerCase()) {
            case "int":
                break;
            case "string":
                break;
            case "decimal":
                setDecimalDigit(text);
                break;
            case "date":
                this.text = StringUtil.getDate(text, 2);
                break;
            case "datatime":
                this.text = StringUtil.getDate(text, 1);
                break;
            default:
                break;
        }
    }

    private String setDecimalDigit(String text) {
        try {
            return text.substring(0, text.indexOf(".") + 1 + info.getIDigit());
        } catch (Exception e) {
            return text;
        }
    }

    private void initData() {

    }
}
