package com.gomore.adv;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DensityUtil {
    public static int dip2px(Context paramContext, float paramFloat) {
        float f = paramContext.getResources().getDisplayMetrics().density;
        return (int) (paramFloat * f + 0.5F);
    }

    public static int px2dip(Context paramContext, float paramFloat) {
        float f = paramContext.getResources().getDisplayMetrics().density;
        return (int) (paramFloat / f + 0.5F);
    }

    public static int sp2px(Context paramContext, float paramFloat) {
        float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (paramFloat * f + 0.5F);
    }

    public static int px2sp(Context paramContext, float paramFloat) {
        float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (paramFloat / f + 0.5F);
    }

    public static int dpToPx(Context context, int dp) {
        int px = Math.round(dp * getPixelScaleFactor(context));
        return px;
    }

    public static int pxToDp(Context context, int px) {
        int dp = Math.round(px / getPixelScaleFactor(context));
        return dp;
    }

    private static float getPixelScaleFactor(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static int screenWith(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //窗口的宽度
        int screenWidth = wm.getDefaultDisplay().getWidth();
        return screenWidth;
    }

    public static int screenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //窗口的宽度
        int screenHeight = wm.getDefaultDisplay().getHeight();
        return screenHeight;
    }
}