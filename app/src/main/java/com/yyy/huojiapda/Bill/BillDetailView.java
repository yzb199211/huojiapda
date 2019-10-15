package com.yyy.huojiapda.Bill;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yyy.huojiapda.R;
import com.yyy.pda.util.PxUtil;

import java.util.List;

public class BillDetailView extends FrameLayout {
    private static final String TAG = "BillDetailView";
    Context context;

    List<BillDetailInfo.Info.FormColumns> columns;
    int screenWidth;
    int w;
    int h;
    int padding;

    public BillDetailView(@NonNull Context context) {
        this(context, null);
    }

    public BillDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        screenWidth = PxUtil.getWidth(context);
        init();
    }

    private void init() {
        initView();
        initData();

    }

    private void initView() {
        padding = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
    }

    private void initData() {
        for (int i = 0; i < columns.size(); i++) {
            BillDetailInfo.Info.FormColumns column = columns.get(i);
            if (column.getIHide() != 0) {
                setView();
            }
        }
    }

    private void setView() {

    }

    public void setColumns(List<BillDetailInfo.Info.FormColumns> columns) {
        this.columns = columns;
    }
}
