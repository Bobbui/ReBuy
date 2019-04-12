package com.example.rebuytest.fragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rebuytest.R;
import com.example.rebuytest.fragment.adapter.MyOrderItemTwoListViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderItemTwoFragment extends Fragment {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_order_item_two, container, false);
        listView = view.findViewById(R.id.myorder_item_2_listview);
        List<Integer> list = getData();
        listView.setAdapter(new MyOrderItemTwoListViewAdapter(getContext(),list));
        return view;
    }

    private List<Integer> getData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(9 + i * 9);
        }
        return list;
    }

}
