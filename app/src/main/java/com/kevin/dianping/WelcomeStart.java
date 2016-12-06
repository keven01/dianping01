package com.kevin.dianping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.kevin.dianping.MainActivity;

import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/10/19.
 */
//延迟跳转 使用handler
public class WelcomeStart extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
//        new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                //实现页面跳转
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                return false;
//            }
//        }).sendEmptyMessageDelayed(0,3000);//表示延迟3秒发送任务
        Timer timer = new Timer();
        timer.schedule(new Tast(),2000);
    }
    class Tast extends TimerTask{
        @Override
        public void run() {
            //实现页面跳转
            if (ShareUtils.getWelcomeBoolean(getBaseContext())){
                startActivity(new Intent(getBaseContext(),MainActivity.class));
            }else {
                startActivity(new Intent(getApplicationContext(),WelcomeGuideAct.class));
                //保存访问记录
                ShareUtils.putWelcomeBoolean(getBaseContext(),true);
            }
            finish();
        }
    }
}
