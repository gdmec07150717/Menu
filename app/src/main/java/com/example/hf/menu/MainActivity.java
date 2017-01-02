package com.example.hf.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private  int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tv1=(TextView) findViewById(R.id.textView);
        registerForContextMenu(tv1);
        count=0;
    }

    //选项菜单创建
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        count++;
       // MenuInflater inflater=getMenuInflater();
       // inflater.inflate(R.menu.menu,menu);
        menu.add(0,1,0,R.string.m1);
        menu.add(0,2,0,R.string.m2);
        menu.add(0,3,0,R.string.m3);
       menu.add(0,count+3,0,"tt"+count);
        return super.onCreateOptionsMenu(menu);
    }

    //选项菜单被选中
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    //上下文菜单的创建
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       count++;
        menu.add(0,1,0,R.string.m1);
        menu.add(0,2,0,R.string.m2);
        menu.add(0,3,0,R.string.m3);
        menu.add(0,count+3,0,"aa"+count);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //上下文菜单被选中
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        count++;
        menu.add(0,count+3,0,"cc"+count);
        return super.onPrepareOptionsMenu(menu);
    }
}
