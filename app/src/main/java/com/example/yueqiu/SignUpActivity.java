package com.example.yueqiu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yueqiu.entity.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class SignUpActivity extends AppCompatActivity {
    private Button mzc;
    private EditText myhm;
    private EditText mmm;
    private String yhm;
    private String mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        initView();
    }

    private void initView() {
        mzc = findViewById(R.id.ljzc);
        myhm = findViewById(R.id.yhm);
        mmm = findViewById(R.id.mm);
        mzc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();

            }
        });
    }

    private void signup() {
        final Intent intent = new Intent(this,LoginActivity.class);

        final User user = new User();
        yhm = String.valueOf(myhm.getText());
        mm = String.valueOf(mmm.getText());
        user.setUsername(yhm);
        user.setPassword(mm);
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Toast.makeText(SignUpActivity.this, "注册成功",
                            Toast.LENGTH_SHORT).show();
                    Log.d("注册", "注册成功");
                    startActivity(intent);
                } else {
                    Log.d("注册", "注册失败:" + e);
                    Toast.makeText(SignUpActivity.this, "注册失败",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



}
