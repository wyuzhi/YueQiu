package com.example.yueqiu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yueqiu.R;
import com.example.yueqiu.entity.YueEasy;

import java.util.List;

public class YueEasyAdapter extends RecyclerView.Adapter<YueEasyAdapter.ViewHolder>{
    private List<YueEasy> mYueEasyList;
    private Context mContext;

    public YueEasyAdapter(Context context,List<YueEasy> YueEasyList){
        mContext = context;
        mYueEasyList = YueEasyList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.ye_item,viewGroup,false);
        final ViewHolder eViewholder = new ViewHolder(view);
        return eViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        YueEasy yueeasy =mYueEasyList.get(i);
        holder.textView.setText(yueeasy.)

    }

    @Override
    public int getItemCount() {
        return mYueEasyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mYongHu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mYongHu = itemView.findViewById(R.id.text_yh);
        }
    }
}
