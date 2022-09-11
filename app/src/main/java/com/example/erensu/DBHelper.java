package com.example.erensu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(fullName TEXT, mail TEXT primary key, password TEXT, adres TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

    }
    public Boolean insertData(String fullName, String mail, String password, String adres) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("fullName", fullName);
        contentValues.put("mail", mail);
        contentValues.put("password", password);
        contentValues.put("adres", adres);
        long result = MyDB.insert("users",  null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkmail(String mail){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where mail = ?", new String [] {mail});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkmailpassword(String mail, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where mail = ? and password = ?",new String[] {mail,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
