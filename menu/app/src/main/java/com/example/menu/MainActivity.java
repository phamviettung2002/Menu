package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView hw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hw = findViewById(R.id.txtHelloworld);
        registerForContextMenu(hw);

        //Popup Menu
        hw.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            PopupMenu pm = new PopupMenu(MainActivity.this, hw);
            pm.getMenuInflater().inflate(R.menu.popup_menu, pm.getMenu());
            pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.popup_1:
                            Chuyentrang();
                            return true;
                        case R.id.popup_2:
                            Chuyentrang();
                            return true;
                        default:
                            return false;
                    }
                }
            });
            pm.show();
        }
        });

    }
    public void Chuyentrang() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Chuyentrang();
                return true;
            case R.id.menu2:
                Chuyentrang();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.context_1:
                Chuyentrang();
            case R.id.context_2:
                Chuyentrang();
            default:
                return super.onContextItemSelected(item);
        }
    }


}