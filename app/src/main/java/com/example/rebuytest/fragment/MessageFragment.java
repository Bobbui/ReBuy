package com.example.rebuytest.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rebuytest.R;
import com.example.rebuytest.adapter.MessageListViewAdapter;
import com.example.rebuytest.fragment.activity.MessageItem1Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private ListView listView;

    /**
     * 自定义了ListView
     * MessageListViewAdapter
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        listView = view.findViewById(R.id.message_listview);
        int[] pic = new int[]{R.drawable.bg_banner1, R.drawable.bg_banner2, R.drawable.bg_banner3};
        List<String> data1 = getData1();
        List<String> data2 = getData2();
        listView.setAdapter(new MessageListViewAdapter(getActivity(), pic,data1,data2));
        initListener();
        return view;
    }


    private List<String> getData1() {
        List<String> list = new ArrayList<>();
        list.add("阿狸啊哈哈哈");
        list.add("Bobbui~~~");
        list.add("DDDDASSSS");
        return list;
    }

    private List<String> getData2() {
        List<String> list = new ArrayList<>();
        list.add("取消订单");
        list.add("申请退款");
        list.add("申请退款");
        return list;
    }

    private void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getContext(), MessageItem1Activity.class);
                        break;
                    case 1:
                        intent = new Intent(getContext(), MessageItem1Activity.class);
                        break;
                    case 2:
                        intent = new Intent(getContext(), MessageItem1Activity.class);
                }
                startActivity(intent);
            }
        });
    }

}
