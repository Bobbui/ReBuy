package com.example.rebuytest.business.home.bean;

import com.youth.banner.Banner;

import java.util.ArrayList;

public class BarBean extends BaseBean {

    private Banner mBanner;
    private ArrayList<Integer> mImagePath;
    private ArrayList<String> mImageTitle;

    public void setmImagePath(ArrayList<Integer> ImagePath) {
        this.mImagePath = ImagePath;
    }

    public void setmImageTitle(ArrayList<String> ImageTitle) {
        this.mImageTitle = ImageTitle;
    }

    public ArrayList<Integer> getmImagePath() {
        return mImagePath;
    }

    public ArrayList<String> getmImageTitle() {
        return mImageTitle;
    }
}
