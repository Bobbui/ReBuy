package com.example.rebuytest.fragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rebuytest.R;
import com.example.rebuytest.activity.LoginActivity;

public class MineInstallActivity extends AppCompatActivity {

    private Button mBtnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_install);
        mBtnReturn = findViewById(R.id.btn_exit);
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
