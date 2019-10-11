package com.yyy.huojiapda.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yyy.huojiapda.R;
import com.yyy.huojiapda.interfaces.OnItemClickListener;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.VH> {
    Context context;
    List<MainMenu.MenusBean.ChildMenusBean> menus;
    OnItemClickListener onItemClickListener;

    public MainMenuAdapter(Context context, List<MainMenu.MenusBean.ChildMenusBean> menus) {
        this.context = context;
        this.menus = menus;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MainMenuAdapter.VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvMenu.setText(menus.get(position).menuName());
        holder.ivMenu.setImageResource(menus.get(position).imgRes());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView tvMenu;
        ImageView ivMenu;

        public VH(View v) {
            super(v);
            tvMenu = v.findViewById(R.id.tv_menu);
            ivMenu = v.findViewById(R.id.iv_menu);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
