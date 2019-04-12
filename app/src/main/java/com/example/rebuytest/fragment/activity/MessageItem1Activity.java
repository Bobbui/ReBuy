package com.example.rebuytest.fragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.rebuytest.R;

public class MessageItem1Activity extends AppCompatActivity {

    private ImageButton mBtnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_item1);
        mBtnReturn = findViewById(R.id.btn_return);
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
