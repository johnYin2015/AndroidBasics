package com.example.dialogdemo;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

public class MyDialog2 extends Dialog {
    public MyDialog2(@NonNull Context context, int themeResId) {
        super(context, themeResId);

        //设置布局
        setContentView(R.layout.dialog_layout);

        findViewById(R.id.yes_btn).setOnClickListener(v -> System.exit(0));

        //dismiss
        findViewById(R.id.no_btn).setOnClickListener(v -> dismiss());
    }
}
