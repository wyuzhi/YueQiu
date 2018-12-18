package com.example.yueqiu.Fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.yueqiu.R;
import com.example.yueqiu.SignUpActivity;
import com.example.yueqiu.YueEasyActivity;

public class YueFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yueqiu,container,false);
        Button yq = view.findViewById(R.id.button_yueqiu);
        yq.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),YueEasyActivity.class);

        switch (v.getId()){
            case R.id.button_yueqiu:
                Toast.makeText(getActivity(), "约球按钮被点击了", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
