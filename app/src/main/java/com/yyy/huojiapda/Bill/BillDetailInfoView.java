package com.yyy.huojiapda.Bill;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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

    private Switch switchView;

    String text;
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
        setTitle();
        setTag(info.getSFieldsName());
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
        editConfig();
    }


    private void setTv() {
        etContent.setVisibility(GONE);
        tvContent.setVisibility(VISIBLE);
        switchView.setVisibility(GONE);
        setTvLimit(info.getSDefaultValue());
        textConfig();
        tvContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLookUpListener != null) {
                    onLookUpListener.onLookUp(tvContent);
                }
            }
        });
    }


    private void setSwitch() {
        etContent.setVisibility(GONE);
        tvContent.setVisibility(GONE);
        switchView.setVisibility(VISIBLE);
        if (StringUtil.isInteger(info.getSDefaultValue())) {
            if (Integer.parseInt(info.getSDefaultValue()) == 1) {
                switchView.setChecked(true);
            }
        }
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


    private void setTitle() {
        tvTitle.setText(info.getSFieldsDisplayName());
        if (StringUtil.isInteger(info.getSNameFontSize()))
            tvTitle.setTextSize(Integer.parseInt(info.getSNameFontSize()));
        if (StringUtil.isColor(info.getSNameFontColor()))
            tvTitle.setTextColor(Color.parseColor(info.getSNameFontColor()));
        if (info.getINameFontBold())
            tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
    }

    private void editConfig() {
        etContent.setText(info.getSDefaultValue());
        if (StringUtil.isInteger(info.getSValueFontSize()))
            etContent.setTextSize(Integer.parseInt(info.getSValueFontSize()));
        if (StringUtil.isColor(info.getSValueFontColor()))
            etContent.setTextColor(Color.parseColor(info.getSValueFontColor()));
        if (info.getIValueFontBold())
            etContent.setTypeface(Typeface.DEFAULT_BOLD);
    }

    private void textConfig() {
        tvContent.setText(info.getSDefaultValue());
        if (StringUtil.isInteger(info.getSValueFontSize()))
            tvContent.setTextSize(Integer.parseInt(info.getSValueFontSize()));
        if (StringUtil.isColor(info.getSValueFontColor()))
            tvContent.setTextColor(Color.parseColor(info.getSValueFontColor()));
        if (info.getIValueFontBold())
            tvContent.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public String getText() {
        return text;
    }
}
