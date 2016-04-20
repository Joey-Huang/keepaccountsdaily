package com.joey.keepaccountsdaily.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.joey.keepaccountsdaily.R;

public class HomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView tv_detail= (TextView) findViewById(R.id.tv_detail);
        TextView tv_account= (TextView) findViewById(R.id.tv_account);
        TextView tv_bbs= (TextView) findViewById(R.id.tv_bbs);
        TextView tv_fund= (TextView) findViewById(R.id.tv_fund);
        TextView tv_stat= (TextView) findViewById(R.id.tv_stat);
        //报表 账户 理财 社区  点击跳转 至 功能待完善 界面
        tv_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectTo(OnCompleting.class);
            }
        });
        tv_bbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectTo(OnCompleting.class);
            }
        });
        tv_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectTo(OnCompleting.class);
            }
        });
        tv_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectTo(OnCompleting.class);
            }
        });
    }

    //跳转界面
    private void redirectTo(Class<OnCompleting> activity) {
        if (!isDestroyed()){
            startActivity(new Intent(HomeActivity.this, activity));
        }
    }


}
