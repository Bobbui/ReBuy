package com.example.rebuytest.business.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rebuytest.R;
import com.example.rebuytest.business.home.bean.BaseBean;
import com.example.rebuytest.business.home.busniess.activity.EasyGoActivity;
import com.example.rebuytest.business.home.busniess.activity.LikeActivity;
import com.example.rebuytest.business.home.busniess.activity.SaleActivity;
import com.example.rebuytest.business.home.widget.GlideImageLoader;
import com.example.rebuytest.utils.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter {

    public final static int TITLE = 1001;

    public final static int BODY = 1002;

    public final static int FOOT = 1003;

    private List<BaseBean> mList;

    private Context context;

    private LayoutInflater layoutInflater;

    public RecycleViewAdapter(List<BaseBean> mList) {
        this.mList = mList;
    }

    /*public class BarHolder extends RecyclerView.ViewHolder {

        Banner mBanner;

        public BarHolder(@NonNull View itemView) {
            super(itemView);
            //mBanner = itemView.findViewById(R.id.banner);
        }
    }*/


    public class BodyHolder extends RecyclerView.ViewHolder {

        LinearLayout mLLEasyGo;
        LinearLayout mLLSale;
        Banner mBanner;
        LinearLayout mLLHomeBody;

        public BodyHolder(@NonNull View itemView) {
            super(itemView);
            mLLEasyGo = itemView.findViewById(R.id.ll_play_free_and_easy);
            mLLSale = itemView.findViewById(R.id.ll_sale);
            mBanner = itemView.findViewById(R.id.banner);
            mLLHomeBody = itemView.findViewById(R.id.home_body);
        }
    }

    public class FootHolder extends RecyclerView.ViewHolder {

        public FootHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size() > 0) {
            return mList.get(position).getViewType();
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        layoutInflater = LayoutInflater.from(context);

        View view;
        RecyclerView.ViewHolder vh = null;

        switch (i) {
            /*case TITLE:
                view = layoutInflater.inflate(R.layout.home_banner, viewGroup, false);
                vh = new BarHolder(view);
                break;*/
            case BODY:
                view = layoutInflater.inflate(R.layout.home_body, viewGroup, false);
                vh = new BodyHolder(view);
                break;
            case FOOT:
                view = layoutInflater.inflate(R.layout.linearlayout_cardview_three, viewGroup,
                        false);
                vh = new FootHolder(view);
                break;
            default:
                break;
        }
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {

        /*if (viewHolder instanceof BarHolder) {
            Log.i("!!!", "This is BarHolder");
            Log.i("!!!","((BarHolder) viewHolder).mBanner.toString()");
            //initBanner(viewHolder);
        }*/

        if (viewHolder instanceof BodyHolder) {

            initBanner(viewHolder);
            ((BodyHolder)viewHolder).mLLEasyGo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.OnViewClick(EasyGoActivity.class);
                }
            });
            ((BodyHolder)viewHolder).mLLSale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.OnViewClick(SaleActivity.class);
                }
            });
            ((BodyHolder)viewHolder).mLLHomeBody.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnToastClickListener.OnToastViewClick("敬请期待");
                }
            });
        }

        if (viewHolder instanceof FootHolder) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.OnViewClick(LikeActivity.class);
                }
            });
        }
    }

    private void initBanner(RecyclerView.ViewHolder viewHolder) {
        ArrayList<Integer> mImagePath = new ArrayList<>();
        ArrayList<String> mImageTitle = new ArrayList<>();
        mImagePath.add(R.drawable.bg_banner1);
        mImagePath.add(R.drawable.bg_banner2);
        mImagePath.add(R.drawable.bg_banner3);
        mImageTitle.add("Pic1");
        mImageTitle.add("Pic2");
        mImageTitle.add("Pic3");
        //设置banner样式
        ((BodyHolder)viewHolder).mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        ((BodyHolder)viewHolder).mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        ((BodyHolder)viewHolder).mBanner.setImages(mImagePath);
        //设置Banner动画效果
        ((BodyHolder)viewHolder).mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合
        ((BodyHolder)viewHolder).mBanner.setBannerTitles(mImageTitle);
        //设置自动轮播
        ((BodyHolder)viewHolder).mBanner.isAutoPlay(true);
        //设置轮播时间
        ((BodyHolder)viewHolder).mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        ((BodyHolder)viewHolder).mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        ((BodyHolder)viewHolder).mBanner.start();
        ((BodyHolder)viewHolder).mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                mOnBannerClickListener.OnBannerViewClick(position);
            }
        });

    }

    /**
     * 活动接口回调
     */
    public interface OnClickListener {
        void OnViewClick(Class clz);
    }

    private OnClickListener mOnClickListener;

    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }


    /**
     * 轮播图接口回调
     */
    public interface OnBannerClickListener {
        void OnBannerViewClick(int position);
    }

    private OnBannerClickListener mOnBannerClickListener;

    public void setmOnBannerClickListener(OnBannerClickListener mOnBannerClickListener) {
        this.mOnBannerClickListener = mOnBannerClickListener;
    }

    /**
     * 文字接口回调
     */
    public interface OnToastClickListener {
        void OnToastViewClick(String msg);
    }

    private OnToastClickListener mOnToastClickListener;

    public void setmOnToastClickListener(OnToastClickListener mOnToastClickListener) {
        this.mOnToastClickListener = mOnToastClickListener;
    }
}
