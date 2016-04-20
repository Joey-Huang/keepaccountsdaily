package com.joey.keepaccountsdaily.activity;

import com.joey.keepaccountsdaily.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;


/**
 * splash 启动界面
 */
public class AppStart extends Activity {
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.app_start, null);
        setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gradientAnim(view);
    }

    // 渐变展示启动屏
    private void gradientAnim(View view) {
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(3000);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
