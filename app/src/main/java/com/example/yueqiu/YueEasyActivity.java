package com.example.yueqiu;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yueqiu.entity.YueEasy;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class YueEasyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yue_easy);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YueEasy ye = new YueEasy();
                ye.setMwz("文昌校区");
                ye.update("39572201e0", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Log.d("修改","修改成功");
                        }else{
                            Log.d("修改","修改失败:"+e);
                        }

                    }
                });
            }
        });
    }
}
