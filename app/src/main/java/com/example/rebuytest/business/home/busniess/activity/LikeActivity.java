package com.example.rebuytest.business.home.busniess.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.rebuytest.R;
import com.example.rebuytest.utils.ToastUtils;

public class LikeActivity extends AppCompatActivity {

    private ImageButton mBtnReturn;
    private Button mBtnContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        mBtnReturn = findViewById(R.id.btn_return);
        mBtnContact = findViewById(R.id.btn_contact_saler);
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(getApplicationContext(),"敬请期待");
            }
        });
    }
}
