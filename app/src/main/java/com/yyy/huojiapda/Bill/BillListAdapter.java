package com.yyy.huojiapda.Bill;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yyy.pda.view.Configure.ConfigureInfo;
import com.yyy.pda.view.Configure.ConfigureView;

import java.util.List;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.VH> {
    Context context;
    List<List<ConfigureInfo>> styles;

    public BillListAdapter(Context context, List<List<ConfigureInfo>> styles) {
        this.context = context;
        this.styles = styles;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new VH(new ConfigureView(context));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.setIsRecyclable(false);
        ((ConfigureView) holder.itemView).setTitleVisiable(false);
        ((ConfigureView) holder.itemView).setInfoList(styles.get(position));
//        ((ReviewStyleView1)holder.itemView).setPadding(0,0,0,context.getResources().getDimensionPixelOffset(R.dimen.dp_10));
    }

    @Override
    public int getItemCount() {
//        Log.e("size",""+styles.size());
        return styles.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(View v) {
            super(v);
        }
    }
}
