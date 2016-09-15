package com.example.com.parallaxscrolldemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<ImageView> list;
    private int[] imagesId = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        viewPager.setAdapter(new MPagerAdapter(this));
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.vp);
        list = new ArrayList<ImageView>();

        ImageView iv = new ImageView(this);
        iv.setBackgroundResource(R.mipmap.ic_launcher);

        for (int i = 0;i<4;i++){
            list.add(iv);
        }

    }

    public  class MPagerAdapter extends PagerAdapter{

        Context mContext;
        public MPagerAdapter(Context context){
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return imagesId.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            ImageView iv = new ImageView(mContext);
            iv.setBackgroundResource(imagesId[position]);
            ((ViewPager)container).addView(iv);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"点击的是第"+position+"张图片！",Toast.LENGTH_SHORT).show();
                }
            });

            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            ImageView iv = new ImageView(mContext);
            iv.setBackgroundResource(imagesId[position]);
            ((ViewPager)container).removeView(iv);
        }

    }
}
