package com.example.rebuytest.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rebuytest.R;
import com.example.rebuytest.activity.EasyGoActivity;
import com.example.rebuytest.activity.SaleActivity;
import com.example.rebuytest.utils.ThreadUtils;
import com.example.rebuytest.utils.ToastUtils;
import com.example.rebuytest.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private Banner mBanner;
    private GlideImageLoader mGlideImageLoader;
    private ArrayList<Integer> mImagePath;
    private ArrayList<String> mImageTitle;
    private LinearLayout mLLEasyGo;
    private LinearLayout mLLSale;
    private LinearLayout mLLLike1;
    private LinearLayout mLLLike2;
    private LinearLayout mLLLike3;
    private LinearLayout mLLLike4;
    private LinearLayout mLLLike5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mBanner = view.findViewById(R.id.banner);
        mLLEasyGo = view.findViewById(R.id.ll_play_free_and_easy);
        mLLSale = view.findViewById(R.id.ll_sale);
        mLLLike1 = view.findViewById(R.id.cardview1);
        mLLLike2 = view.findViewById(R.id.cardview2);
        mLLLike3 = view.findViewById(R.id.cardview3);
        mLLLike4 = view.findViewById(R.id.cardview4);
        mLLLike5 = view.findViewById(R.id.cardview5);
        initData();
        initView();
        initLinearlayoutView();
        return view;
    }

    /**
     * 导入图片数据
     */
    private void initData() {
        mImagePath = new ArrayList<>();
        mImageTitle = new ArrayList<>();
        mImagePath.add(R.drawable.bg_banner1);
        mImagePath.add(R.drawable.bg_banner2);
        mImagePath.add(R.drawable.bg_banner3);
        mImageTitle.add("Pic1");
        mImageTitle.add("Pic2");
        mImageTitle.add("Pic3");
    }

    /**
     * 设置轮播图样式
     */
    private void initView() {
        mGlideImageLoader = new GlideImageLoader();
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(mImagePath);
        //设置Banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合
        mBanner.setBannerTitles(mImageTitle);
        //设置自动轮播
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtils.showToast(getContext(), "你点了第" + (position + 1) + "张轮播图");
            }
        });


    }

    private void initLinearlayoutView() {

        mLLEasyGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EasyGoActivity.class);
                startActivity(intent);
            }
        });
        mLLSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SaleActivity.class);
                startActivity(intent);
            }
        });

    }

}
