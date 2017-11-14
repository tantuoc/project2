package com.example.tom.project2_tbdd.sqlLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tom on 11/6/2017.
 */

public class UserCreate extends SQLiteOpenHelper {
    public static final String DB_USER = "USER";
    public static final int DB_VER = 1;

    public static final String TB_USER = "user";
    public static final String ID_USER = "_id";
    public static final String NAME_USER = "username";
    public static final String PASS_USER = "password";
    public static final String EMAIL_USER = "email";
    public static final String GENRE_USER = "genre";

    public UserCreate(Context context) {
        super(context, DB_USER, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TB_USER + "(" + ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_USER + " TEXT, " +
                PASS_USER + " TEXT, " + EMAIL_USER + " TEXT, " + GENRE_USER + " INT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE EXITS" + TB_USER);
    }
}
