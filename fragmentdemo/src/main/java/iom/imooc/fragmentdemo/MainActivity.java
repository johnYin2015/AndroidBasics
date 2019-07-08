package iom.imooc.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements ListFragment.OnTitleClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views on onclick event.

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // static load fragment.
            startActivity(new Intent(MainActivity.this, StaticLoadFragmentActivity.class));
            }
        });

        // 1. container  2. fragment  3. fragment-->container


        // activity--->fragment value
        ListFragment listFragment = ListFragment.newInstance("list");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listContainer, listFragment)
                .commit();
        listFragment.setOnTitleClickListener(this);

        ListFragment detail = ListFragment.newInstance("detail");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detailContainer, detail)
                .commit();

        detail.setOnTitleClickListener(this);


    }

    @Override
    public void onClick(String title) {
        setTitle(title);
    }
}
