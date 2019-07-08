package com.john.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class TabViewPagerActivity extends AppCompatActivity implements TabHost.TabContentFactory {

    private ViewPager mViewPager;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_viewpager);

        //#总布局初始化
        mTabHost = (TabHost) findViewById(R.id.tab_host);
        mTabHost.setup();//qianwan别忘了这一步，否则会报错：java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.TabWidget.setStripEnabled(boolean)' on a null object reference

        //初始化控件
        mViewPager = findViewById(R.id.vp);


        //#3个tab进行处理
        //##标题、图片集合
        int[] titleIDs = {
                R.string.home,
                R.string.message,
                R.string.me
        };
        int[] drawableIDs = {
                R.drawable.main_tab_icon_home,
                R.drawable.main_tab_icon_message,
                R.drawable.main_tab_icon_me
        };

        for (int i = 0; i < titleIDs.length; i++) {
            //##view加载
            View view = getLayoutInflater().inflate(R.layout.main_tab_layout, null, false);
            ImageView icon = view.findViewById(R.id.main_tab_icon);
            TextView title = view.findViewById(R.id.main_tab_txt);
            View tab = view.findViewById(R.id.tab_bg);

            //##数据塞到视图中
            icon.setImageResource(drawableIDs[i]);
            title.setText(getString(titleIDs[i]));
            tab.setBackgroundColor(getResources().getColor(R.color.white));

            //##view设置给tab，tab添加到tabhost中
//            mTabHost.addTab(
////                    mTabHost.newTabSpec(getString(titleIDs[i]))
////                            .setIndicator(view)
////                            .setContent(this)
////            );

            mTabHost.addTab(
                    mTabHost.newTabSpec(getString(titleIDs[i]))
                            .setIndicator(view)
                            .setContent(this)//不需要内容，但调用该api，必须要设置，所以让Act implements TabHost.TabContentFactory,实现方法中new 一个View返回
            );

        }

        //#3个fragment组成viewpager
        //初始化数据
        final Fragment[] fragments = {
                TestFragment.newInstance("home"),
                TestFragment.newInstance("message"),
                TestFragment.newInstance("me")
        };

        //创建adapter
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });

        setListeners();
    }

    private void setListeners() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mTabHost != null)
                    mTabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (mTabHost != null){
                    int position = mTabHost.getCurrentTab();
                    mViewPager.setCurrentItem(position);
                }
            }
        });
    }

    @Override
    public View createTabContent(String tag) {
        View view = new View(this);
        view.setMinimumHeight(0);
        view.setMinimumWidth(0);
        return view;
    }
}
