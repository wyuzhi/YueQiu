package com.example.yueqiu;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.yueqiu.Adapter.YueEasyAdapter;
import com.example.yueqiu.entity.YueEasy;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class YueEasyActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<YueEasy> yeList;
    private Handler mHander;
    private YueEasyAdapter mYueEasyAdapter;
    private SwipeRefreshLayout mSwipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yue_easy);
        initView();

        }




    private void initView() {
        mSwipeRefresh = findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDate();
            }
        });
        mRecyclerView =findViewById(R.id.recycler_ye);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        yeList = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YueEasyActivity.this, FaBuActivity.class);
                startActivity(intent);
            }
        });
        loadDate();
    }
    private void loadDate(){
        BmobQuery<YueEasy> yeQuery = new BmobQuery<>();
        yeQuery.findObjects(new FindListener<YueEasy>() {
            @Override
            public void done(List<YueEasy> list, BmobException e) {
                if (e == null) {
                    mYueEasyAdapter = new YueEasyAdapter(YueEasyActivity.this,list);
                    mRecyclerView.setAdapter(mYueEasyAdapter);
                    Log.d("查询", "查询成功"+list);
                } else {
                    Log.d("查询", "查询失败:" + e);
                }
            }
        });
    }
}
