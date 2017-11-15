package com.example.tom.project2_tbdd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.tom.project2_tbdd.R;
import com.example.tom.project2_tbdd.adapter.ListAccountAdapter;
import com.example.tom.project2_tbdd.dao.UserDAO;
import com.example.tom.project2_tbdd.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    UserDAO userDAO;
    List<User> userlist;
    ListView ls;
    BaseAdapter bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDAO = new UserDAO(this);
        ls = findViewById(R.id.listView);
        userlist = userDAO.getListUser();

        bs = new ListAccountAdapter(this, R.layout.list_account, userlist);
        bs.notifyDataSetChanged();
        ls.setAdapter(bs);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        registerForContextMenu(ls);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuView:

                break;
            case R.id.menuEdit:
                AdapterView.AdapterContextMenuInfo menuinfoE = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                Toast.makeText(this,userlist.get(menuinfoE.position).getId()+"", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuDel:

                AdapterView.AdapterContextMenuInfo menuinfoD = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                User u = userlist.get(menuinfoD.position);
                userDAO.delUser(u);
                userlist.remove(menuinfoD.position);
                bs.notifyDataSetChanged();
                Toast.makeText(this, item.getTitle()+ " success!", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
