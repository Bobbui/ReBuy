package com.example.rebuytest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuytest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EasyGoTabOneFragment extends Fragment {


    public EasyGoTabOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_easy_go_tab_one, container, false);
    }

}
