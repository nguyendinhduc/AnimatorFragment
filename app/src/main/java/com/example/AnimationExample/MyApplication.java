package com.example.AnimationExample;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by ducnd on 02/09/2015.
 */
public class MyApplication extends Application{
    public static int WIDTH_SCREEN, HEIGHT_SCREEN;
    public static float densityDpi;
    private Bitmap bmActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }
    private void initialize() {
        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        WIDTH_SCREEN = displayMetrics.widthPixels;
        HEIGHT_SCREEN = displayMetrics.heightPixels;
        densityDpi = (float)displayMetrics.densityDpi;
    }
    public Bitmap getbmActivity() {
        return bmActivity;
    }
    public void setBmActivity( Bitmap bmActivity ) {
        this.bmActivity = bmActivity;
    }
}
