package com.example.uidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        //1.获取按钮
        Button btn1 = findViewById(R.id.btn1);
        //点击事件：被点击时被触发的事件
        MyClickListener mcl = new MyClickListener();
        btn1.setOnClickListener(mcl);       //2.为按钮注册点击事件监听器

        //匿名内部类适用于有唯一操作的按钮
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在控制台输出
                Log.e("TAG","==========匿名内部类==========");
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
}

    @Override
    public void onClick(View view) {
        Log.e("TAG","用本类实现了OnClickListener");
    }

    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //在控制台输出一条语句
            Log.e("TAG","刚刚点击的按钮时注册了内部类监听器对象的按钮");
        }
    }

    //参数：被点击的控件对象
    public void myClick(View v){
        switch (v.getId()){
            case R.id.btn4:
                Log.e("TAG","btn4======");
                break;
            case R.id.btn5:
                Log.e("TAG","btn5======");
                break;

        }
    }
}
