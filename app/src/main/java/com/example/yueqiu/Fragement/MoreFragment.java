package com.example.yueqiu.Fragement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yueqiu.R;
import com.example.yueqiu.SignUpActivity;
import com.example.yueqiu.entity.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MoreFragment extends Fragment implements View.OnClickListener {
    private String dlyhm;
    private String dlmm;
    private EditText yhm;
    private EditText mm;
    private Button dl;
    private Button zc;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        dl = view.findViewById(R.id.dl_dl);
        dl.setOnClickListener(this);
        zc = view.findViewById(R.id.dl_zc);
        zc.setOnClickListener(this);
        yhm = view.findViewById(R.id.dl_yhm);
        mm = view.findViewById(R.id.dl_mm);
        mContext=getContext();
        return view;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), SignUpActivity.class);
        switch (v.getId()) {
            case R.id.dl_zc:
                Toast.makeText(getActivity(), "去注册", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

            case R.id.dl_dl:
                loginb(getView());
                break;
            default:
                break;
        }

    }

    private void loginb(final View view) {
        dlyhm= String.valueOf(yhm.getText());
        dlmm= String.valueOf(mm.getText());
        final User dluser=new User();
        dluser.setUsername(dlyhm);
        dluser.setPassword(dlmm);
        dluser.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Log.d("登陆", "登陆成功");
                    Toast.makeText(mContext, "登陆成功",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("登陆", "登陆失败:" + e);
                    Toast.makeText(mContext, "用户名或密码错误",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
