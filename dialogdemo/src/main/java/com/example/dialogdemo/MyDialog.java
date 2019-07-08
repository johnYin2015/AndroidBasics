package com.example.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

public class MyDialog extends Dialog {

    public MyDialog(@NonNull final Context context, int themeResId) {
        super(context, themeResId);
        //为对话框设置布局
        setContentView(R.layout.dialog_layout);

        findViewById(R.id.yes_btn).setOnClickListener(view -> System.exit(0));

        findViewById(R.id.no_btn).setOnClickListener(view -> dismiss());
    }
}
