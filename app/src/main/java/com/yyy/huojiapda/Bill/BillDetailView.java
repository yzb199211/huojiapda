package com.yyy.huojiapda.Bill;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yyy.huojiapda.R;
import com.yyy.pda.util.PxUtil;

import java.util.List;

public class BillDetailView extends FrameLayout {
    private static final String TAG = "BillDetailView";
    Context context;

    List<BillDetailInfo.Info.FormColumns> columns;

    int w;
    int h;
    int itemWidth;
    int padding;

    public BillDetailView(@NonNull Context context) {
        this(context, null);
    }

    public BillDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        init();
    }

    private void init() {
        initView();
        initData();

    }

    private void initView() {
        padding = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
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
                setView(column);
            }
        }
    }

    private void setView(BillDetailInfo.Info.FormColumns column) {

    }

    public void setColumns(List<BillDetailInfo.Info.FormColumns> columns) {
        this.columns = columns;
    }
}
