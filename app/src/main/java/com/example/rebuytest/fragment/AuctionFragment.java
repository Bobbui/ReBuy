package com.example.rebuytest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rebuytest.R;
import com.example.rebuytest.adapter.AuctionListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuctionFragment extends Fragment {


    /**
     * 自定义了一个ListView
     */

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auction, container, false);
        listView = (ListView) view.findViewById(R.id.auction_listview);
        List<Integer> list1 = getData1();
        List<Integer> list2 = getData2();
        listView.setAdapter(new AuctionListViewAdapter(getActivity(),list1,list2));
        return view;
    }

    /**
     * 放入了简单的数据
     * @return
     */
    private List<Integer> getData1() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list1.add(88 + i * 8);
        }
        return list1;
    }

    private List<Integer> getData2() {
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list2.add(10 + i);
        }
        return list2;
    }

}
