package com.example.tom.project2_tbdd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import com.example.tom.project2_tbdd.model.User;

import com.example.tom.project2_tbdd.sqlLite.UserCreate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 11/6/2017.
 */

public class UserDAO {
    private UserCreate uc;
    private SQLiteDatabase db;
    private String[] colums = {UserCreate.ID_USER, UserCreate.NAME_USER, UserCreate.PASS_USER, UserCreate.EMAIL_USER, UserCreate.GENRE_USER};

    public UserDAO(Context context) {
        uc = new UserCreate(context);
        open();
    }

    public void open() {
        db = uc.getWritableDatabase();

    }

    public void close() {
        uc.close();

    }

    public boolean addUser(User u) {
        ContentValues cv = new ContentValues();
        cv.put(UserCreate.NAME_USER, u.getUsername());
        cv.put(UserCreate.PASS_USER, u.getPassword());
        cv.put(UserCreate.EMAIL_USER, u.getEmail());
        cv.put(UserCreate.GENRE_USER, u.getGenre());

        long id_user = db.insert(UserCreate.TB_USER, null, cv);

        if (id_user != 0) {
            return true;
        } else
            return false;
    }


    public List<User> getListUser() {
        List<User> listUser = new ArrayList<User>();
        User u;
        Cursor cur = db.query(UserCreate.TB_USER, colums, null, null, null, null, null);
        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            int _id = cur.getInt(0);
            String username = cur.getString(1);
            String password = cur.getString(2);
            String email = cur.getString(3);
            long genre = cur.getLong(4);
            u = new User(username, password, email, genre);
            listUser.add(u);
            cur.moveToNext();
        }

        return listUser;
    }
    public boolean login(String username,String password){

        Cursor cur = db.query(UserCreate.TB_USER, colums, null, null, null, null, null);
        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            String user = cur.getString(1);
            String pass = cur.getString(2);
            if(username.trim().equalsIgnoreCase(user)&&password.trim().equals(pass)){
                return  true;
            }
            else {
                cur.moveToNext();
            }
        }
        return false;

    }

}
