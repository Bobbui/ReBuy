package com.example.rebuytest.business.mine.business.myorder.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.rebuytest.R;
import com.example.rebuytest.business.mine.business.myorder.view.fragment.MyOrderTabDoneFragment;
import com.example.rebuytest.business.mine.business.myorder.view.fragment.MyOrderTabUndoneFragment;

import java.util.ArrayList;
import java.util.List;

public class MineMyOrderActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mTabViewPager;
    private ImageButton mBtnReturn;
    private List<Fragment> mFragments = new ArrayList<>();
    private String[] mTitle = {"未完成","已完成"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_my_order);
        mTabLayout = findViewById(R.id.myorder_tablayout);
        mTabViewPager = findViewById(R.id.myorder_viewpager);
        mBtnReturn = findViewById(R.id.btn_return);
        init();
        initListener();
    }


    private void init() {
        //添加Fragment
        mFragments.add(new MyOrderTabDoneFragment());
        mFragments.add(new MyOrderTabUndoneFragment());
        mTabViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        mTabLayout.setupWithViewPager(mTabViewPager);

        //设置每一个Tab
        mTabLayout.getTabAt(0).setText(mTitle[0]);
        mTabLayout.getTabAt(1).setText(mTitle[1]);
    }


    /**
     * 设置Tab和Button的监听事件
     */
    private void initListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabViewPager.setCurrentItem(tab.getPosition());
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
