package com.example.dialogdemo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;//?
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void myClick(View view) {
        switch (view.getId()){
            case R.id.normal_dialog_btn:
                //AlertDialog的构造方法时protected
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示X")
                .setMessage("您确定退出程序吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
                break;
            case R.id.diy_dialog_btn:
                MyDialog md = new MyDialog(this,R.style.MyDialog2);
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
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,items);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.array_item_layout,items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.array_item_layout,R.id.item_txt,items);
        AlertDialog.Builder builer = new AlertDialog.Builder(this)
                .setTitle("请选择")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main2Activity.this,items[which],Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
        builer.show();
    }

    /**
     *
     * @param view 基于此view,即锚
     */
    private void showPopupWindow(View view) {
        Log.e("TAG","showPopupWindow");
        View v = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);

        //true:可以获取焦点
        PopupWindow popupWindow = new PopupWindow(v, 190, 35, true);

        //背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        popupWindow.setAnimationStyle(R.style.translate_anim2);

        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
//
        //view:锚
        //x,y:x y方向上的偏移量
        popupWindow.showAsDropDown(view,-190,0);

        //为弹窗中的文本设置点击事件
        v.findViewById(R.id.choose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"您点击了选择",Toast.LENGTH_SHORT).show();
                //让弹窗消失
                popupWindow.dismiss();
            }
        });
    }


}
