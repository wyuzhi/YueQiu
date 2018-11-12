package com.example.yueqiu.Fragement;

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

public class YueFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yueqiu,container,false);
        Button yq = view.findViewById(R.id.button_yueqiu);
        yq.setOnClickListener(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_yueqiu:
                Toast.makeText(getActivity(), "约球按钮被点击了", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
