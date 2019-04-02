package com.example.rebuytest.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rebuytest.R;
import com.example.rebuytest.utils.LoginAndRegisterUtil;
import com.example.rebuytest.utils.ThreadUtils;
import com.example.rebuytest.utils.ToastUtils;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private TextView mEtUserName;
    private TextView mEtPassword;
    private TextView mEtConfirmPassword;
    private Button mBtnCancle;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initRegisterListener();
        initCancleListener();
    }

    /**
     * 注册按钮
     */
    private void initRegisterListener() {
        mBtnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean flag = false;
                final String username = mEtUserName.getText().toString();
                final String password = mEtPassword.getText().toString();
                final String confirmPassword = mEtConfirmPassword.getText().toString();
                if (username.length() > 0 && password.length() > 0 && password.equals(confirmPassword)) {
                    LoginAndRegisterUtil.setUsername(username);
                    LoginAndRegisterUtil.setPassword(password);
                    flag = true;
                } else {
                    ToastUtils.showToast(RegisterActivity.this, "请输入您的用户名和密码");
                }

                if (flag == true) {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        });
    }

    /**
     * 取消按钮,返回上一个活动
     */
    private void initCancleListener() {
        mBtnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mEtUserName = findViewById(R.id.et_register_username);
        mEtPassword = findViewById(R.id.et_register_password);
        mEtConfirmPassword = findViewById(R.id.et_register_confirm_password);
        mBtnCancle = findViewById(R.id.btn_register_cancle);
        mBtnRegister = findViewById(R.id.btn_register_register);
    }
}
