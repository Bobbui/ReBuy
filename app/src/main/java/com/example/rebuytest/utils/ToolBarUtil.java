package com.example.rebuytest.utils;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.ArrayList;
import java.util.List;

public class ToolBarUtil {

    private List<TextView> mTextViews = new ArrayList<>();

    public void createToolBar(LinearLayout container, String[] toolbarTitleArr, int[] iconArr) {

        for (int i = 0; i < toolbarTitleArr.length; i++) {
            TextView tv = (TextView) View.inflate(container.getContext(),
                    R.layout.inflate_toolbar_btn, null);
            tv.setText(toolbarTitleArr[i]);

            //动态修改TextView里面的drawableTop属性
            tv.setCompoundDrawablesWithIntrinsicBounds(0, iconArr[i], 0, 0);

            int width = 0;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);

            //设置weight属性
            params.weight = 1;
            container.addView(tv, params);
            mTextViews.add(tv);

            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //3.需要传值的地方用接口对象调用接口方法
                    mOnToolBarClickListener.OnToolBarCLick(finalI);
                }
            });
        }
    }

    public void changeColor(int poisition) {
        //还原所有颜色
        for (TextView tv : mTextViews) {
            tv.setSelected(false);
        }
        mTextViews.get(poisition).setSelected(true);//通过设置selected属性控制为选中效果
    }

    /**
     * 接口回调
     */
    public interface OnToolBarClickListener {
        void OnToolBarCLick(int position);
    }

    private OnToolBarClickListener mOnToolBarClickListener;

    public void setmOnToolBarClickListener(OnToolBarClickListener mOnToolBarClickListener) {
        this.mOnToolBarClickListener = mOnToolBarClickListener;
    }

}
