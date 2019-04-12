package com.example.rebuytest;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.example.rebuytest.activity.LoginActivity;
import com.example.rebuytest.activity.MainActivity;
import com.example.rebuytest.utils.ThreadUtils;

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
     * 加入点击进入倒计时?
     */

    private Animation.AnimationListener am = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            //Intent intent1 = new Intent(SplashActivity.this, MainActivity.class);
            //startActivity(intent1);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

    };
}
