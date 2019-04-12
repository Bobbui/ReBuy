package com.example.rebuytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rebuytest.R;

import java.util.List;

public class MineListViewAdapter extends BaseAdapter {
    private int[] pic = null;
    private List<String> data1 = null;
    private LayoutInflater layoutInflater;
    private Context context;

    public MineListViewAdapter(Context context, int[] pic, List<String> data1) {
        this.context = context;
        this.pic = pic;
        this.data1 = data1;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 组件集合，对应auction_list里的控件
     *
     * @return
     */

    private final class Component {
        private ImageView mImgMine;
        private TextView mtvMine;
    }

    @Override
    public int getCount() {
        return pic.length;
    }

    /**
     * 获得某一位置的数据
     *
     * @param position
     * @return
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
        Component component = null;
        if (convertView == null) {
            component = new Component();

            //获得组件，实例化组件
            convertView = layoutInflater.inflate(R.layout.mine_list, null);
            component.mImgMine = convertView.findViewById(R.id.img_mine);
            component.mtvMine = convertView.findViewById(R.id.tv_mine);
            convertView.setTag(component);
        } else {
            component = (Component) convertView.getTag();
        }

        //绑定数据
        component.mImgMine.setImageResource(pic[position]);
        component.mtvMine.setText(data1.get(position));
        return convertView;
    }
}
