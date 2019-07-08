package com.me.singleton;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    private Context mContext;

    private MyApp(){
        mContext = this;
        return;
    }
}
