package com.joey.keepaccountsdaily.activity;

import com.joey.keepaccountsdaily.AppManager;
import com.joey.keepaccountsdaily.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;


/**
 * splash 启动界面
 */
public class AppStart extends Activity {
    private  final int gotoHome=1;
    private  final int gradientOver=2;


    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.app_start, null);
        setContentView(view);
        AppManager.getAppManager().addActivity(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        gradientAnim(view);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case gotoHome:
                    redirectTo();//跳转界面
                    break;
                case gradientOver://渐变效果完成
                    sendEmptyMessage(gotoHome);
                    break;
            }


            super.handleMessage(msg);
        }
    };



    // 渐变展示启动屏
    private void gradientAnim(View view) {
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(3000);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                handler.sendEmptyMessage(gradientOver);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    //跳转界面
    private void redirectTo() {
        if (!isDestroyed()) {
            //未销毁状态下跳转
            startActivity(new Intent(this, HomeActivity.class));
            AppManager.getAppManager().finishActivity(this);
        }
    }
}
