package com.example.dialogdemo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNormalDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("您确定退出程序吗？");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    public void myClick(View view) {
        switch (view.getId()){
            case R.id.normal_dialog_btn:
                //AlertDialog的构造方法时protected
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("您确定退出程序吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
//                AlertDialog dialog = builder.create();
//                dialog.show();
                break;
            case R.id.diy_dialog_btn:
                MyDialog md = new MyDialog(this,R.style.mydialog);
                md.show();
                break;
            case R.id.popup_btn:
                showPopupWindow(view);
                break;
            case R.id.arrayAdapter_btn:
                showArrayDialog();
                break;
        }
    }
    private void showArrayDialog() {
        final String[] items = {"Java","Mysql","Android","HTML","C","JavaScript"};
        //数组适配器
        //参数1：环境
        //参数2：布局资源索引，指的是每一项数据所呈现的样式android.R.layout.xxx
        //参数3：数据源
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,items);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.array_item_layout,R.id.item_txt,items);
        AlertDialog.Builder builer = new AlertDialog.Builder(this)
                .setTitle("请选择")
                //参数1：适配器对象（对数据显示样式的规则制定器）
                //参数2：监听器
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,items[i],Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
        builer.show();
    }

    //设置PopupWindow
    public void showPopupWindow(View view) {
        //准备弹窗所需要的视图对象
        View v = LayoutInflater.from(this).inflate(R.layout.popup_layout,null);
        //1.实例化对象
        //参数1：用在弹窗中的View
        //参数2、3：弹窗的宽高
        //参数4（focusable）：能否获取焦点
        final PopupWindow window = new PopupWindow(v,250,135,true);

        //2.设置（背景、动画）
        //设置背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置能响应外部的点击事件
        window.setOutsideTouchable(true);
        //设置能响应点击事件
        window.setTouchable(true);
        //①创建动画资源   ②创建一个style应用动画资源    ③对当前弹窗的动画风格设置为第二部的资源索引
        window.setAnimationStyle(R.style.translate_anim);

        //3.显示
        //参数1(anchor)：锚
        //参数2、3：相对于锚在x、y方向上的偏移量
        window.showAsDropDown(view,-190,0);

        //为弹窗中的文本添加点击事件
        v.findViewById(R.id.choose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"您点击了选择",Toast.LENGTH_SHORT).show();
                window.dismiss();   //控制弹窗消失
            }
        });

        v.findViewById(R.id.choose_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"您点击了全选",Toast.LENGTH_SHORT).show();
                window.dismiss();
            }
        });

        v.findViewById(R.id.copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"您点击了复制",Toast.LENGTH_SHORT).show();
                window.dismiss();
            }
        });
    }
}

