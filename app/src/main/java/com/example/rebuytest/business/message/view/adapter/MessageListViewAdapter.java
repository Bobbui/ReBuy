package com.example.rebuytest.business.message.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.List;

public class MessageListViewAdapter extends BaseAdapter {

    private int[] pic;
    private List<String> mDataMoney;
    private List<String> mDataPopular;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MessageListViewAdapter(Context context, int[] pic,List<String> data1,List<String> data2) {
        this.mContext = context;
        this.pic = pic;
        this.mDataMoney = data1;
        this.mDataPopular = data2;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 组件集合，对应auction_list里的控件
     * @return
     */

    private final class Component {
        private ImageView mImage;
        private TextView mtvName;
        private TextView mtvStatus;
    }
    @Override
    public int getCount() {
        return pic.length;
    }

    /**
     * 获得某一位置的数据
     * @param position
     * @return pic
     */
    @Override
    public Object getItem(int position) {
        return pic[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageListViewAdapter.Component component = null;
        if (convertView == null) {
            component = new MessageListViewAdapter.Component();

            //获得组件，实例化组件
            convertView = mLayoutInflater.inflate(R.layout.message_list,null);
            component.mImage = convertView.findViewById(R.id.message_image);
            component.mtvName = convertView.findViewById(R.id.tv_message_name);
            component.mtvStatus = convertView.findViewById(R.id.tv_message_status);
            convertView.setTag(component);
        } else {
            component = (MessageListViewAdapter.Component) convertView.getTag();
        }

        //绑定数据
        component.mImage.setImageResource(pic[position]);
        component.mtvName.setText(mDataMoney.get(position));
        component.mtvStatus.setText(mDataPopular.get(position));
        return convertView;
    }
}
