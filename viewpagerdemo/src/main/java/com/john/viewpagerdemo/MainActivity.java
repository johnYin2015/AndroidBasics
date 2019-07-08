package com.john.viewpagerdemo;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private int[] mLayoutIDs = {
            R.layout.view_first,
            R.layout.view_second,
            R.layout.view_third};
    private List<View> mViews;
    //ui上和数据源上，点
    private ViewGroup mDotViewGroup;
    private List<ImageView> mDotViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp);
        mDotViewGroup = findViewById(R.id.ll_dot);

        //数据
        mViews = new ArrayList<>();
        mDotViews = new ArrayList<>();
        for (int i = 0; i < mLayoutIDs.length; i++) {
            //mViews.add(getLayoutInflater().inflate(mLayoutIDs[i], null, false));
            //app引导页
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.mipmap.ic_launcher);
            mViews.add(imageView);

            //点
            ImageView dotView = new ImageView(this);
            dotView.setImageResource(R.mipmap.ic_launcher);//设置图片
            //设置最大size
            dotView.setMaxWidth(20);
            dotView.setMaxHeight(20);
            //点添加到点集中
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(15, 15);
            lp.leftMargin = 5;
            dotView.setLayoutParams(lp);
            //禁用指示器
            dotView.setEnabled(false);

            mDotViewGroup.addView(dotView);//添加到布局中

            mDotViews.add(dotView);
        }

        //定义适配器

        //setadpater
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.setOffscreenPageLimit(4);//缓存

        mViewPager.setCurrentItem(0);//+
        setDotViews(0);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setDotViews(position);//+
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setDotViews(int position) {
        for (int i = 0; i < mDotViews.size(); i++) {
            mDotViews.get(i).setImageResource(position==i?R.mipmap.diglett:R.mipmap.ic_launcher);
        }
    }

    //匿名内部类
    PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
//            return mLayoutIDs.length;
            return mLayoutIDs.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //int newPos = position % mLayoutIDs.length;
            View view = mViews.get(position);

            /*if (view.getParent()!=null){
                ViewGroup viewGroup = (ViewGroup)view.getParent();
                viewGroup.removeView(view);
            }*/
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //int newPos = position % mLayoutIDs.length;
            container.removeView(mViews.get(position));
        }
    };
}
