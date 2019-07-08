package com.example.para_huang.imoocapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //contextMenu
        //1.注册
//        registerForContextMenu(findViewById(R.id.ctx_btn));
        //2.创建
        //3.菜单项的操作
        //4.为按钮设置上下文启动模式
        //  (1)实现ActionMode Callback
        //  (2)在View的长按事件中启动上下文操作模式
//        findViewById(R.id.ctx_btn).setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                startActionMode(cb);
//                return false;
//            }
//        });

        //popupMenu
        final Button btnPopup = (Button) findViewById(R.id.popup_btn);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Main2Activity.this,btnPopup);
                //将菜单资源加载到菜单中
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                //设置监听
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.copy:
                                Toast.makeText(Main2Activity.this, "复制", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.paste:
                                Toast.makeText(Main2Activity.this, "粘贴", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                //显示popupMenu,千万别忘
                popupMenu.show();
            }
        });
    }

    /*ActionMode.Callback cb = new ActionMode.Callback() {
        //startActionMode时调用
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Log.e("TAG", "创建");
            getMenuInflater().inflate(R.menu.context, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Log.e("TAG", "准备");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.e("TAG", "点击");
            switch (item.getItemId()) {
                case R.id.delete:
                    Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.opera1:
                    Toast.makeText(Main2Activity.this, "操作1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.opera2:
                    Toast.makeText(Main2Activity.this, "操作2", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Log.e("TAG", "结束");
        }
    };*/

    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }*/

    /*@Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opera1:
                Toast.makeText(this, "操作1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opera2:
                Toast.makeText(this, "操作2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                break;
            case R.id.setting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.more_oper:
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }*/
}
