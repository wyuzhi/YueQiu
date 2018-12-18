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

public class YueEasyAdapter extends RecyclerView.Adapter<YueEasyAdapter.ViewHolder> {
    private List<YueEasy> mYueEasyList;
    private Context mContext;
    private View.OnClickListener mListener;

    public YueEasyAdapter(Context context, List<YueEasy> YueEasyList) {
        mContext = context;
        mYueEasyList = YueEasyList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.ye_item, viewGroup, false);
        final ViewHolder eViewholder = new ViewHolder(view);
        return eViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YueEasy yeItem = mYueEasyList.get(position);
        if (yeItem == null) {
            return;
        }
        int qrs = yeItem.getQrs();
        String wz = yeItem.getWz();
        String sj = yeItem.getSj();

        holder.mQrs.setText("缺人数： " + qrs);
        holder.mSj.setText("时间： " + sj);
        holder.mWz.setText("位置： " + wz);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//点击事件
            }
        });
    }

    @Override
    public int getItemCount() {
        return mYueEasyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mWz;
        private TextView mSj;
        private TextView mQrs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mWz = itemView.findViewById(R.id.text_wz);
            mSj = itemView.findViewById(R.id.text_sj);
            mQrs = itemView.findViewById(R.id.text_qrs);
        }
    }
}
/*
wz:位置
sj:时间
qrs:缺人数
 */
