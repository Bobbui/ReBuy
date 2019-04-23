package com.example.rebuytest.business.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rebuytest.R;
import com.example.rebuytest.business.home.adapter.RecycleViewAdapter;
import com.example.rebuytest.business.home.bean.BarBean;
import com.example.rebuytest.business.home.bean.BaseBean;
import com.example.rebuytest.business.home.bean.BodyBean;
import com.example.rebuytest.business.home.bean.FootBean;
import com.example.rebuytest.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private List<BaseBean> mList = new ArrayList<>();

    private RecyclerView mRecycleView;
    private RecycleViewAdapter adapter;

    GridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecycleView = view.findViewById(R.id.home_recycle_view);
        initAdapter();
        //initBanner();
        initBody();
        initFoot();
        initListener();
        return view;
    }

    /**
     * 初始化Adapter
     */
    private void initAdapter() {

        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                int type = mRecycleView.getAdapter().getItemViewType(i);
                if (type == RecycleViewAdapter.FOOT) {
                    return 1;
                } else return gridLayoutManager.getSpanCount();
            }
        });

        adapter = new RecycleViewAdapter(mList);
        mRecycleView.setLayoutManager(gridLayoutManager);
        mRecycleView.setAdapter(adapter);


    }


    /**
     * 初始化home的Banner
     */
    private void initBanner() {
        BarBean barBean = new BarBean();
        barBean.setViewType(RecycleViewAdapter.TITLE);
        mList.add(barBean);
        Log.i("!!!", "initBanner");
    }


    /**
     * 初始化home的Body
     */

    private void initBody() {
        Log.i("!!!", "initBody()");
        List<Integer> layout = new ArrayList<>();
        layout.add(R.id.home_body);
        BodyBean bodyBean = new BodyBean();
        bodyBean.setLayout(layout);
        bodyBean.setViewType(RecycleViewAdapter.BODY);
        mList.add(bodyBean);
    }


    /**
     * 初始化home的Foot
     */
    private void initFoot() {
        Log.i("!!!", "initFoot()");
        for (int i = 0; i < 18; i++) {
            FootBean footBean = new FootBean(R.id.cardview);
            footBean.setViewType(RecycleViewAdapter.FOOT);
            mList.add(footBean);
        }
    }


    /**
     * 设置图片的点击事件
     */
    private void initListener() {
        adapter.setmOnToastClickListener(new RecycleViewAdapter.OnToastClickListener() {
            @Override
            public void OnToastViewClick(String msg) {
                ToastUtils.showToast(getContext(),msg);
            }
        });

        adapter.setmOnClickListener(
                new RecycleViewAdapter.OnClickListener() {
                    @Override
                    public void OnViewClick(Class clz) {
                        Intent intent = new Intent(getContext(), clz);
                        startActivity(intent);
                    }
                });


        adapter.setmOnBannerClickListener(new RecycleViewAdapter.OnBannerClickListener() {
            @Override
            public void OnBannerViewClick(int position) {
                ToastUtils.showToast(getContext(), "你点了第" + (position + 1) + "张轮播图");
            }
        });
    }
}