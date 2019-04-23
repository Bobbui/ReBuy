package com.example.rebuytest.business.mine.view.fragment;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.rebuytest.R;
import com.example.rebuytest.business.mine.business.settings.MineSettingsActivity;
import com.example.rebuytest.business.mine.business.mycollection.activity.MineMyCollectionActivity;
import com.example.rebuytest.business.mine.business.myinfo.activity.MineMyInfoActivity;
import com.example.rebuytest.business.mine.business.myorder.view.activity.MineMyOrderActivity;
import com.example.rebuytest.business.mine.business.myshop.view.activity.MineMyShopActivity;
import com.example.rebuytest.business.mine.view.adapter.MineListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment {

    private LinearLayout mLinearLayout;
    private ListView mUpListView;
    private ListView mDownListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        mLinearLayout = view.findViewById(R.id.ll_mine_homepage);
        init();
        mUpListView = view.findViewById(R.id.mine_listview1);
        mDownListView = view.findViewById(R.id.mine_listview2);
        int[] pic1 = {R.drawable.ic_personal_info, R.drawable.ic_shop, R.drawable.ic_order};
        int[] pic2 = {R.drawable.ic_collection, R.drawable.ic_install};
        List<String> list1 = getDataPic();
        List<String> list2 = getDataList();
        mUpListView.setAdapter(new MineListViewAdapter(getContext(), pic1, list1));
        mDownListView.setAdapter(new MineListViewAdapter(getContext(), pic2, list2));
        initListener();
        return view;
    }

    /**
     * 数据的初始化
     *
     * @return list
     */
    private List<String> getDataPic() {
        List<String> list = new ArrayList<>();
        list.add("个人资料");
        list.add("我的小店");
        list.add("我的订单");
        return list;
    }

    private List<String> getDataList() {
        List<String> list = new ArrayList<>();
        list.add("我的收藏");
        list.add("设置");
        return list;
    }

    private void init() {
        Resources resources = getContext().getResources();
        Drawable drawable = resources.getDrawable(R.drawable.bg_banner2);
        drawable.setAlpha(70);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLinearLayout.setBackground(drawable);
        }
    }

    /**
     * 设置ListView的监听事件
     */
    private void initListener() {

        mUpListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getContext(), MineMyInfoActivity.class);
                        break;
                    case 1:
                        intent = new Intent(getContext(), MineMyShopActivity.class);
                        break;
                    case 2:
                        intent = new Intent(getContext(), MineMyOrderActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });

        mDownListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getContext(), MineMyCollectionActivity.class);
                        break;
                    case 1:
                        intent = new Intent(getContext(), MineSettingsActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }

}
