package com.example.rebuytest.fragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.rebuytest.R;
import com.example.rebuytest.adapter.AuctionListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MineMyCollectionActivity extends AppCompatActivity {


    /**
     * 自定义了一个ListView
     */

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_my_collection);
        listView = findViewById(R.id.mine_my_collection);
        List<Integer> list1 = getData1();
        List<Integer> list2 = getData2();
        listView.setAdapter(new AuctionListViewAdapter(MineMyCollectionActivity.this,list1,list2));
    }

    /**
     * 放入了简单的数据
     * @return list
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
