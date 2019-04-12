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
import com.example.rebuytest.fragment.fragment.MyShopItemOneFragment;
import com.example.rebuytest.fragment.fragment.MyShopItemTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MineMyShopActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager tabViewPager;
    private ImageButton mBtnReturn;
    private List<Fragment> mfragments = new ArrayList<>();
    private String[] title = {"正在销售","成功销售"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_my_shop);
        tabLayout = findViewById(R.id.myshop_tablayout);
        tabViewPager = findViewById(R.id.myshop_viewpager);
        mBtnReturn = findViewById(R.id.btn_return);
        init();
        initListener();
    }

    /**
     * 需要先添加碎片，再添加Tab，否则会重复创建Tab
     */
    private void init() {
        //添加Fragment
        mfragments.add(new MyShopItemOneFragment());
        mfragments.add(new MyShopItemTwoFragment());
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

        //将TabViewPager添加到TabLayout
        tabLayout.setupWithViewPager(tabViewPager);
        //添加Tab
        tabLayout.getTabAt(0).setText(title[0]);
        tabLayout.getTabAt(1).setText(title[1]);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
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
