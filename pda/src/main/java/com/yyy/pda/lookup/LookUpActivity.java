package com.yyy.pda.lookup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yyy.pda.R;
import com.yyy.pda.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookUpActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvTitle;
    ImageView ivBack;
    EditText etSearch;
    TextView tvEmpty;
    RecyclerView rvItem;

    int code;
    String title;
    List<LookUpBean> mlist;
    List<LookUpBean> showList;
    LookUpAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up);

        try {
            initView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() throws Exception {
        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        tvEmpty = findViewById(R.id.tv_empty);
        etSearch = findViewById(R.id.et_search);
        rvItem = findViewById(R.id.rv_item);
        ivBack.setOnClickListener(this);
        ivBack.setVisibility(View.VISIBLE);
        showList = new ArrayList<>();
        mlist = new ArrayList<>();
        Intent intent = getIntent();
        code = intent.getIntExtra("code", 0);
        title = intent.getStringExtra("title");
        String data = intent.getStringExtra("data");
        Log.e("data", data);
        mlist = new Gson().fromJson(data, new TypeToken<List<LookUpBean>>() {
        }.getType());
//        Log.e("dara", mlist.size() + "");
        showList.addAll(mlist);
//        Log.e("dara", showList.size() + "");
        tvTitle.setText(title);
        refreshList();
        setLookUp();


    }

    private void setLookUp() throws Exception {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    getShowList(s.toString());
                    refreshList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private List<LookUpBean> getShowList(String name) throws Exception {
        Pattern pattern = Pattern.compile(name);
        showList.clear();
        for (int i = 0; i < mlist.size(); i++) {
            Matcher matcher = pattern.matcher(mlist.get(i).getName());
            if (matcher.find()) {
                showList.add(mlist.get(i));
            }
        }
        return showList;
    }

    private void refreshList() throws Exception {
        if (mAdapter == null) {
            mAdapter = new LookUpAdapter(this, showList);
            rvItem.setLayoutManager(new LinearLayoutManager(this));
            rvItem.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent();
                    intent.putExtra("name", mlist.get(position).getName());
                    intent.putExtra("id", mlist.get(position).getId());
                    Log.e("TAG", mlist.get(position).getId() + "");
                    intent.putExtra("link_id", mlist.get(position).getLink_id());
                    setResult(code, intent);
                    finish();
                }
            });
        } else {
            if (showList.size() == 0) {
                rvItem.setVisibility(View.GONE);
                tvEmpty.setVisibility(View.VISIBLE);
            } else {
                rvItem.setVisibility(View.VISIBLE);
                tvEmpty.setVisibility(View.GONE);
            }
            mAdapter.notifyDataSetChanged();
        }

    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
