package com.example.layoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.layout_constraint2);
    }

    public void myclick(View v){
        switch (v.getId()){
            case R.id.frame:
//                startActivity(new Intent(this,FrameActivity.class));
                break;
            case R.id.constraint:
                break;
        }
    }
}
