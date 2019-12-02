package com.bwie.zhouxinguang122.app;
/*
 *@auther:周鑫光
 *@Date: 2019/12/2
 *@Time:8:42
 *@Description:${DESCRIPTION}
 * */

import android.app.Application;
import android.content.Context;

public class Appcotion extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
