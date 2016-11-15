package net.thanatosx.widgets;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by thanatos on 16/10/1.
 */

public class BaseApplication extends Application{

    private static Context context;
    private static Resources resource;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        resource = getResources();
    }

    public static Context getContext() {
        return context;
    }

    public static Resources getResource() {
        return resource;
    }
}
