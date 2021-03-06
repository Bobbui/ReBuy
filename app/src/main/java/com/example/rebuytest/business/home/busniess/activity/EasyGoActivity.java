package com.example.rebuytest.business.home.busniess.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rebuytest.R;
import com.example.rebuytest.business.home.busniess.fragment.EasyGoSaleFragment;
import com.example.rebuytest.business.home.busniess.fragment.EasyGoAuctionFragment;
import com.example.rebuytest.business.home.busniess.fragment.EasyGoExchangeFragment;

import java.util.ArrayList;
import java.util.List;

public class EasyGoActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mTabViewPager;
    private ImageButton mBtnReturn;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"一口价", "物换物", "拍卖品"};
    private int[] icons = new int[]{R.drawable.ic_yikoujia, R.drawable.ic_exchange,
            R.drawable.ic_auction};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_go);
        mTabViewPager = findViewById(R.id.easygo_viewpager);
        mTabLayout = findViewById(R.id.easygo_tablayout);
        mBtnReturn = findViewById(R.id.btn_return);
        init();
        initListener();
    }

    /**
     * 初始化Tab
     * 使用setupWithViewPager要在Fragment创建之后使用，
     * 且使用该函数后会自动创建于Fragment数量相对应的Tab
     */
    private void init() {
        //添加Fragment
        fragments.add(new EasyGoSaleFragment());
        Log.i("!!!", String.valueOf(mTabLayout.getTabCount()) + "1");
        fragments.add(new EasyGoExchangeFragment());
        Log.i("!!!", String.valueOf(mTabLayout.getTabCount()) + "2");
        fragments.add(new EasyGoAuctionFragment());
        Log.i("!!!", String.valueOf(mTabLayout.getTabCount()) + "3");

        mTabViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }
        });

        mTabLayout.setupWithViewPager(mTabViewPager);

        /*.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setupWithViewPager(tabViewPager);*/

        //添加Tab

        mTabLayout.getTabAt(0).setCustomView(makeTabView(0));
        mTabLayout.getTabAt(1).setCustomView(makeTabView(1));
        mTabLayout.getTabAt(2).setCustomView(makeTabView(2));

        Log.i("!!!", String.valueOf(mTabLayout.getTabCount()));

        //使得Tab平分选项卡
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    /**
     * 设置 Tab 和 Button 的监听事件
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

    /**
     * 引入自定义Tab布局
     *
     * @param position
     * @return
     */
    private View makeTabView(int position) {
        View customTabView = (View) LayoutInflater.from(this).inflate(R.layout.custom_tabview,
                null);
        TextView textView = customTabView.findViewById(R.id.custom_tabview_text);
        ImageView imageView = customTabView.findViewById(R.id.custon_tabview_image);
        textView.setText(titles[position]);
        imageView.setImageResource(icons[position]);
        return customTabView;
    }

}
