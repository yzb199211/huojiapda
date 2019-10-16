package com.yyy.huojiapda.Bill;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yyy.huojiapda.R;
import com.yyy.huojiapda.interfaces.OnLookUpListener;
import com.yyy.huojiapda.util.EditInputFilter;
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

    String title;
    String content;

    String fieldType;
    String text;

    int viewType;
    OnLookUpListener onLookUpListener;

    public void setOnLookUpListener(OnLookUpListener onLookUpListener) {
        this.onLookUpListener = onLookUpListener;
    }

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
        setEditLimit();
    }

    private void setTv() {
        etContent.setVisibility(GONE);
        tvContent.setVisibility(VISIBLE);
        switchView.setVisibility(GONE);
        setTvLimit(tvContent.getText().toString());
        tvContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLookUpListener != null) {
                    onLookUpListener.onLookUP(info.getSFieldsName(), tvContent);
                }
            }
        });
    }


    private void setSwitch() {
        etContent.setVisibility(GONE);
        tvContent.setVisibility(GONE);
        switchView.setVisibility(VISIBLE);
    }


    private void setEditLimit() {
        switch (info.getSFieldsType().toLowerCase()) {
            case "int":
                etContent.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
                break;
            case "decimal":
                InputFilter[] filters = {new EditInputFilter(info.getIDigit())};
                etContent.setFilters(filters);
                break;
        }
    }

    private void setTvLimit(String text) {
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

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public void setTitleBold(boolean titleBold) {
        this.titleBold = titleBold;
    }

    public void setContentBold(boolean contentBold) {
        this.contentBold = contentBold;
    }

    public void setSingleLine(boolean singleLine) {
        this.singleLine = singleLine;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
