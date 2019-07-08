package com.imooc.tao.imtao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;

import com.imooc.tao.imtao.fragment.FindFragment;
import com.imooc.tao.imtao.fragment.MainFragment;
import com.imooc.tao.imtao.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected MainFragment mainFragment = new MainFragment();
    protected FindFragment findFragment = new FindFragment();
    protected MeFragment meFragment = new MeFragment();
    private LinearLayout mainMenu;
    private LinearLayout findMenu;
    private LinearLayout meMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        //默认显示首页，其他页面隐藏
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rl_content, mainFragment)
                .add(R.id.rl_content, findFragment)
                .hide(findFragment)
                .add(R.id.rl_content, meFragment)
                .hide(meFragment)
                .commit();
    }

    private void initView() {
        mainMenu = findViewById(R.id.menu_main);
        findMenu = findViewById(R.id.menu_find);
        meMenu = findViewById(R.id.menu_me);

        mainMenu.setOnClickListener(this);
        findMenu.setOnClickListener(this);
        meMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_main://首页
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mainFragment)
                        .hide(findFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_find://发现
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .show(findFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_me://我的
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .hide(findFragment)
                        .show(meFragment)
                        .commit();
                break;
        }

    }

    private boolean isOnline() {
        //        ConnectivityManager 网络连接结果 连接状态改变通知app
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();//第1个 网络连接状态
        TextWatcher tv;
        return activeNetworkInfo!=null && activeNetworkInfo.isConnected();
    }
}
