package com.example.rebuytest.business;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.example.rebuytest.R;
import com.example.rebuytest.business.account.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //splash页面
        View view = findViewById(R.id.rl_splash);
        //开始渐变
        AlphaAnimation anim = new AlphaAnimation(0.1f, 1.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);

        //进入登录界面
        anim.setAnimationListener(am);
    }

    /**
     * 加入倒计时点击按钮?
     */

    private Animation.AnimationListener am = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            //Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            //startActivity(intent);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

    };
}
