package com.example.tom.project2_tbdd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDAO = new UserDAO(this);
        ls = findViewById(R.id.listView);
        userlist = userDAO.getListUser();

        BaseAdapter bs = new ListAccountAdapter(this,R.layout.list_account,userlist);
        bs.notifyDataSetChanged();
        ls.setAdapter(bs);


    }
}
