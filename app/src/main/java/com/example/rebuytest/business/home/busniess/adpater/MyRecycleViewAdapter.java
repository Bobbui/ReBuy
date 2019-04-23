package com.example.rebuytest.business.home.busniess.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuytest.R;
import com.example.rebuytest.business.home.adapter.RecycleViewAdapter;
import com.example.rebuytest.business.home.bean.BaseBean;
import com.example.rebuytest.business.home.busniess.activity.LikeActivity;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter {

    private List<Integer> mList;

    private Context context;

    private LayoutInflater layoutInflater;

    public MyRecycleViewAdapter(List<Integer> mList) {
        this.mList = mList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.easy_go_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.OnViewClick(LikeActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnClickListener {
        void OnViewClick(Class clz);
    }

    private OnClickListener mOnClickListener;

    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
}

