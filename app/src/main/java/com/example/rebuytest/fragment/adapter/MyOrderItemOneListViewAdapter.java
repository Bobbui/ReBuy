package com.example.rebuytest.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.List;

public class MyOrderItemOneListViewAdapter extends BaseAdapter {

    private List<Integer> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyOrderItemOneListViewAdapter(Context context, List<Integer> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
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
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
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
            convertView = layoutInflater.inflate(R.layout.myorderitem1_list,null);
            component.mtvMoney = convertView.findViewById(R.id.tv_money);
            convertView.setTag(component);
        } else {
            component =(Component) convertView.getTag();
        }

        //绑定数据
        component.mtvMoney.setText(String.valueOf(data.get(position)));
        return convertView;
    }
}
