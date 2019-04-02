package com.example.rebuytest.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebuytest.widget.PagerSlide;
import com.example.rebuytest.R;
import com.example.rebuytest.fragment.AuctionFragment;
import com.example.rebuytest.fragment.HomeFragment;
import com.example.rebuytest.fragment.MessageFragment;
import com.example.rebuytest.fragment.MineFragment;
import com.example.rebuytest.utils.ToolBarUtil;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView mMainTvTitle;

    public PagerSlide mMainviewpager;

    public LinearLayout mMainBottom;

    private List<Fragment> mFragments = new ArrayList<Fragment>();

    private ToolBarUtil mtoolBarUtil;

    private String[] mtoolBarTitleArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainTvTitle = (TextView) findViewById(R.id.main_tv_title);
        mMainviewpager = (PagerSlide) findViewById(R.id.mainrecycleview);
        mMainBottom = (LinearLayout) findViewById(R.id.main_bottom);
        mMainviewpager.setSlide(false);
        initData();
        initListener();
    }

    private void initListener() {
        mMainviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //修改颜色
                mtoolBarUtil.changeColor(i);
                //修改Title
                mMainTvTitle.setText(mtoolBarTitleArr[i]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //调用ToolBarUtil中的接口
        mtoolBarUtil.setmOnToolBarClickListener(new ToolBarUtil.OnToolBarClickListener() {
            @Override
            public void OnToolBarCLick(int position) {
                //改变Fragment
                /*FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainrecycleview,mFragments.get(position));
                transaction.commit();*/

                mMainviewpager.setCurrentItem(position);
            }
        });
    }

    private void initData() {

        //导入四个Fragment
        mFragments.add(new HomeFragment());
        mFragments.add(new AuctionFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MineFragment());
        mMainviewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //底部按钮
        mtoolBarUtil = new ToolBarUtil();

        //文字内容
        mtoolBarTitleArr = new String[]{"首页", "拍卖", "信息", "我的"};
        //图表内容
        int[] iconArr = {R.drawable.selector_home, R.drawable.selector_auction,
                R.drawable.selector_message, R.drawable.selector_mine};

        mtoolBarUtil.createToolBar(mMainBottom, mtoolBarTitleArr, iconArr);

        //设置默认选中会话
        mtoolBarUtil.changeColor(0);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        private MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
