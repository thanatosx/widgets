package net.thanatosx.widgets.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import net.thanatosx.widgets.BaseApplication;

/**
 * ui kits
 * Created by thanatos on 16/10/1.
 */

public class UIKit {

    public static DisplayMetrics getDisplayMetrics(){
        return BaseApplication.getResource().getDisplayMetrics();
    }

    public static int getDeviceWidth(){
        return getDisplayMetrics().widthPixels;
    }

    public static int getDeviceHeight(){
        return getDisplayMetrics().heightPixels;
    }

    public static float dp2px(float dp) {
        return dp * getDisplayMetrics().density;
    }

    public static float px2dp(float px) {
        return px / getDisplayMetrics().density;
    }

}
