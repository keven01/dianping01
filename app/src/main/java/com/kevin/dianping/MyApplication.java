package com.kevin.dianping;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/11/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xUtils
        x.Ext.init(this);
    }
}
