package com.example.rebuytest.fragment.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.rebuytest.R;
import com.example.rebuytest.fragment.fragment.MyOrderItemTwoFragment;
import com.example.rebuytest.fragment.fragment.MyOrderItemOneFragment;

import java.util.ArrayList;
import java.util.List;

public class MineMyOrderActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager tabViewPager;
    private ImageButton mBtnReturn;
    private List<Fragment> mfragments = new ArrayList<>();
    private String[] titles = {"未完成","已完成"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_my_order);
        tabLayout = findViewById(R.id.myorder_tablayout);
        tabViewPager = findViewById(R.id.myorder_viewpager);
        mBtnReturn = findViewById(R.id.btn_return);
        init();
        initListener();
    }


    private void init() {
        //添加Fragment
        mfragments.add(new MyOrderItemTwoFragment());
        mfragments.add(new MyOrderItemOneFragment());
        tabViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mfragments.get(i);
            }

            @Override
            public int getCount() {
                return mfragments.size();
            }
        });
        tabLayout.setupWithViewPager(tabViewPager);

        //设置每一个Tab
        tabLayout.getTabAt(0).setText(titles[0]);
        tabLayout.getTabAt(1).setText(titles[1]);
    }


    /**
     * 设置Tab和Button的监听事件
     */
    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
