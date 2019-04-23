package com.example.rebuytest.business.message.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.rebuytest.R;
import com.example.rebuytest.utils.ToastUtils;

public class MessageContentActivity extends AppCompatActivity {

    private ImageButton mBtnReturn;
    private Button mBtnContactSaler;
    private Button mBtnAgreeApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_item);
        mBtnReturn = findViewById(R.id.btn_return);
        mBtnContactSaler = findViewById(R.id.btn_contact_saler);
        mBtnAgreeApplication = findViewById(R.id.btn_agree_applicate);
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnContactSaler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(getApplicationContext(),"敬请期待");
            }
        });

        mBtnAgreeApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(getApplicationContext(),"敬请期待");
            }
        });
    }
}
