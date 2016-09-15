package com.example.com.parallaxscrolldemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/11.
 */
public class ParallaxScrollView extends ScrollView {


    private int numOfParallaxViews =2 ;
    private float innerParallaxFactor = 1.9f;
    private float parallaxFactor = 1.9f;
    private static final String TAG = "ParallaxScrollView";

    private List<ParallaxedView> parallaxViews = new ArrayList<ParallaxedView>();

    public ParallaxScrollView(Context context) {
        this(context,null);
    }

    public ParallaxScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ParallaxScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        makeViewsParallax();

    }

    private void makeViewsParallax() {

        if (getChildCount() > 0 && getChildAt(0) instanceof ViewGroup) {
            ViewGroup viewsHolder = (ViewGroup) getChildAt(0);
            int numOfParallaxViews = Math.min(this.numOfParallaxViews, viewsHolder.getChildCount());
            for (int i = 0; i < numOfParallaxViews; i++) {
                ParallaxedView parallaxedView = new ParallaxedView(viewsHolder.getChildAt(i));
                parallaxViews.add(parallaxedView);
            }

        }


    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float parallax = parallaxFactor;
        for (ParallaxedView parallaxedView : parallaxViews) {
            parallaxedView.setOffSet((float)t/parallax);
            parallax*=innerParallaxFactor;

        }


    }


}
