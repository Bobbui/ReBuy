package com.example.rebuytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<Integer> data1;
    private List<Integer> data2;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListViewAdapter(Context context,List<Integer> data1,List<Integer> data2) {
        this.context = context;
        this.data1 = data1;
        this.data2 = data2;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 组件集合，对应auction_list里的控件
     * @return
     */

    public final class Component {
        public TextView mtvMoney;
        public TextView mtvPeopleAttend;
    }
    @Override
    public int getCount() {
        return data1.size();
    }

    /**
     * 获得某一位置的数据
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return data1.get(position);
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

            //获得组件，实例化组件
            convertView = layoutInflater.inflate(R.layout.auction_list,null);
            component.mtvMoney = convertView.findViewById(R.id.tv_momey);
            component.mtvPeopleAttend = convertView.findViewById(R.id.tv_people_attend);
            convertView.setTag(component);
        } else {
            component = (Component) convertView.getTag();
        }

        //绑定数据
        component.mtvMoney.setText(String.valueOf(data1.get(position)));
        component.mtvPeopleAttend.setText(String.valueOf(data2.get(position)));
        return convertView;
    }
}
