package com.example.memery;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/**
 * Created by Administrator on 2017/1/19.
 */

public class BaseApplication extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        //1. 获取Context
        context = getApplicationContext();
        //2. 创建handler
        handler = new Handler();
        //3. 获取主线程id
        mainThreadId = android.os.Process.myTid();
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }


}
