package com.example.rebuytest.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class PagerSlide extends ViewPager {

    private boolean isSlide = false;

    public PagerSlide(@NonNull Context context) {
        super(context);
    }

    public PagerSlide(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置不能滑动
     *
     * @param slide
     */
    public void setSlide(boolean slide) {
        this.isSlide = slide;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return isSlide && super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return isSlide;
    }

    /**
     * 设置改变Fragment没有滑动效果
     * @param item
     */
    @Override
    public void setCurrentItem(int item) {
        //false 去除滚动效果
        super.setCurrentItem(item, false);
    }
}
