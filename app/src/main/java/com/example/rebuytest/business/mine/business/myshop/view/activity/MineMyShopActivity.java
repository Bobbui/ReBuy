package com.example.rebuytest.business.mine.business.myshop.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.rebuytest.R;
import com.example.rebuytest.business.mine.business.myshop.view.fragment.MyShopTabOnSaleFragment;
import com.example.rebuytest.business.mine.business.myshop.view.fragment.MyShopTabSaleOutFragment;

import java.util.ArrayList;
import java.util.List;

public class MineMyShopActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mTabViewPager;
    private ImageButton mBtnReturn;
    private List<Fragment> mFragments = new ArrayList<>();
    private String[] mTitle = {"正在销售","成功销售"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_my_shop);
        mTabLayout = findViewById(R.id.myshop_tablayout);
        mTabViewPager = findViewById(R.id.myshop_viewpager);
        mBtnReturn = findViewById(R.id.btn_return);
        init();
        initListener();
    }

    /**
     * 需要先添加碎片，再添加Tab，否则会重复创建Tab
     */
    private void init() {
        //添加Fragment
        mFragments.add(new MyShopTabOnSaleFragment());
        mFragments.add(new MyShopTabSaleOutFragment());
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

        //将TabViewPager添加到TabLayout
        mTabLayout.setupWithViewPager(mTabViewPager);
        //添加Tab
        mTabLayout.getTabAt(0).setText(mTitle[0]);
        mTabLayout.getTabAt(1).setText(mTitle[1]);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
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
