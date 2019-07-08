package com.example.uidemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view) {

        EditText etName = (EditText) findViewById(R.id.name);
        EditText etPwd = (EditText) findViewById(R.id.et_pwd);
        final

        ProgressBar pb = (ProgressBar)findViewById(R.id.pb);

        String name = etName.getText().toString();
        String pwd = etPwd.getText().toString();

        //1.判空。为空提示；否则显示进度条
        if (name.equals("") || pwd.equals(""))
            Toast.makeText(this,"用户名或密码为空",Toast.LENGTH_LONG).show();
        else {
            pb.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run() {
                    for (int i = 1; i <= 100; i++) {
                        pb.setProgress(i);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
        }

    }

    interface IDriver{
        int age = 30;//psfi ...
        void driveCar();
    }

    public static void show(IDriver iDriver){
        iDriver.driveCar();
    }

    public static void main(String[] args) {
        show(new IDriver() {
            @Override
            public void driveCar() {
                System.out.println(IDriver.age+"岁的司机开着车");

                List<Integer> list = new ArrayList();
                Iterator<Integer> iterator = list.iterator();
                System.out.println(iterator.next());
            }
        });
    }
}
