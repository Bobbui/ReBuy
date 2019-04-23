package com.example.rebuytest.business.mine.business.myshop.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.List;

public class MyShopTabSaleOutListViewAdapter extends BaseAdapter {

    private List<Integer> mDataList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MyShopTabSaleOutListViewAdapter(Context context, List<Integer> data) {
        this.mContext = context;
        this.mDataList = data;
        this.mLayoutInflater = LayoutInflater.from(context);
    }


    /**
     * 组件集合
     * @return
     */

    public final class Component {
        public TextView mtvMoney;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Component component = null;
        if (convertView == null) {
            component = new Component();
            convertView = mLayoutInflater.inflate(R.layout.myshopitem2_list,null);
            component.mtvMoney = convertView.findViewById(R.id.tv_myshop_item2_money);
            convertView.setTag(component);
        } else {
            component =(Component) convertView.getTag();
        }

        //绑定数据
        component.mtvMoney.setText(String.valueOf(mDataList.get(position)));
        return convertView;
    }
}