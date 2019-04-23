package com.example.rebuytest.business.auction.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.List;

public class AuctionListViewAdapter extends BaseAdapter {

    private List<Integer> mDataMoney;
    private List<Integer> mDataPopular;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public AuctionListViewAdapter(Context context, List<Integer> data1, List<Integer> data2) {
        this.mContext = context;
        this.mDataMoney = data1;
        this.mDataPopular = data2;
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
        return mDataMoney.size();
    }

    /**
     * 获得某一位置的数据
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mDataMoney.get(position);
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
        component.mtvMoney.setText(String.valueOf(mDataMoney.get(position)));
        component.mtvPeopleAttend.setText(String.valueOf(mDataPopular.get(position)));
        return convertView;
    }
}
