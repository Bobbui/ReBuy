package com.example.rebuytest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rebuytest.R;
import com.example.rebuytest.utils.LoginAndRegisterUtil;
import com.example.rebuytest.utils.ThreadUtils;
import com.example.rebuytest.utils.ToastUtils;

public class LoginActivity extends AppCompatActivity {

    private TextView mEtUserName;
    private TextView mEtPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initClickListener();
    }

    private void initClickListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = mEtUserName.getText().toString();
                final String password = mEtPassword.getText().toString();

                /*Log.i("!!!", "usename=" + username);
                if (username == null)
                    Log.i("!!!", "usename=" + username);
                if (username == "") {
                    Log.i("!!!", "usename=" + username);
                } else {
                    Log.i("!!!", "NULL");
                }*/
                //判断是否注册以及用户名密码是否正确
                if (LoginAndRegisterUtil.getUsername() == null || LoginAndRegisterUtil.getPassword() == null) {
                    ToastUtils.showToast(LoginActivity.this, "请先注册");

                } else if (username.equals(LoginAndRegisterUtil.getUsername()) && password.equals(LoginAndRegisterUtil.getPassword())) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    ToastUtils.showToast(LoginActivity.this, "用户名或密码错误!");
                }
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mEtUserName = findViewById(R.id.et_login_username);
        mEtPassword = findViewById(R.id.et_login_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_login_register);
    }
}
