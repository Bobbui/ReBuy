package com.example.rebuytest.business.home.busniess.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rebuytest.R;
import com.example.rebuytest.business.home.adapter.RecycleViewAdapter;
import com.example.rebuytest.business.home.busniess.adpater.MyRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class EasyGoSaleFragment extends Fragment {

    private List<Integer> mList = new ArrayList<>();
    private RecyclerView mRecycleView;
    private MyRecycleViewAdapter adapter;
    private LinearLayout mLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_easy_go_tab_one, container, false);
        mRecycleView = view.findViewById(R.id.tab_easygo_recycleview);
        initData();
        initAdapter();
        initListener();
        return view;
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            mList.add(R.id.easy_go_list);
        }
    }

    private void initAdapter() {
        adapter = new MyRecycleViewAdapter(mList);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleView.setAdapter(adapter);
    }

    private void initListener() {
        adapter.setmOnClickListener(new MyRecycleViewAdapter.OnClickListener() {
            @Override
            public void OnViewClick(Class clz) {
                Intent intent = new Intent(getContext(),clz);
                startActivity(intent);
            }
        });
    }
}
