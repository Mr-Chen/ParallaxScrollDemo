package com.example.com.parallaxscrolldemo;

import android.os.Build;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/9/11.
 */
public  class ParallaxedView {

    static public boolean isAPI11 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    protected WeakReference<View> view;


    public ParallaxedView(View view){

        this.view = new WeakReference<View>(view);
    }


    public void setOffSet(float offSet) {
        View view = this.view.get();
        if (view != null) {
            if (isAPI11) {
                view.setTranslationY(offSet);
            } else {

            }
        }
    }


}
