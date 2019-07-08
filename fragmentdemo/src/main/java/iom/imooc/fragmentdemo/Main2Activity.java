package iom.imooc.fragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements ListFragment2.OnTitleClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // static load fragment
                startActivity(new Intent(Main2Activity.this, StaticLoadFragmentActivity2.class));
            }
        });

        //动态加载fragment
        //1.container 2.fragment 3.fragment放入container

//        ListFragment2 listFragment2 = new ListFragment2();

        //事务提交
        ListFragment2 fragment2 = ListFragment2.newInstance("list");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listContainer, fragment2)
                .commit();//AppCompatActivity-->FragmentActivity
        fragment2.setOnTitleClickListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detailContainer, ListFragment2.newInstance("detail"))
                .commit();//AppCompatActivity-->FragmentActivity

//        getSupportFragmentManager()
//                .beginTransaction()
//                .remove(listFragment2)
//                .commit();//AppCompatActivity-->FragmentActivity

        //replace
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.detailContainer, new ListFragment())
//                .commit();//AppCompatActivity-->FragmentActivity
    }

    @Override
    public void onTitleClick(String title) {
        setTitle(title);
    }
}
