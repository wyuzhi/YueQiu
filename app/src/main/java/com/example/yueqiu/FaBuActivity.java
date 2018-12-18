package com.example.yueqiu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yueqiu.entity.YueEasy;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class FaBuActivity extends AppCompatActivity {
    private Button mfb;
    private EditText et_qrs;
    private EditText et_sj;
    private EditText et_wz;
    private int qrs;
    private String sj;
    private String wz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        initView();
    }

    private void initView() {
        mfb =findViewById(R.id.but_fb);
        et_qrs = findViewById(R.id.fb_qrs);
        et_sj = findViewById(R.id.fb_sj);
        et_wz = findViewById(R.id.fb_wz);
        mfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FaBu();
            }
        });
    }

    private void FaBu() {
        YueEasy fb =new YueEasy();
        qrs = Integer.parseInt(String.valueOf(et_qrs.getText()));
        sj = String.valueOf(et_sj.getText());
        wz= String.valueOf(et_wz.getText());
        fb.setMqrs(qrs);
        fb.setMsj(sj);
        fb.setMwz(wz);
        fb.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Log.d("发布", "发布成功");
                    Toast.makeText(FaBuActivity.this, "发布成功",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("发布", "发布失败:" + e);
                    Toast.makeText(FaBuActivity.this, "发布失败",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
