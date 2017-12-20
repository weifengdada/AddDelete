package com.bwei.exam20;

import android.app.Application;
import android.widget.WrapperListAdapter;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by acer on 2017/12/20.
 */

public class IApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
