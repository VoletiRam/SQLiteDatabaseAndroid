package com.example.dell.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 21-02-2018.
 */

public class DBHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME="kaushik";
    public static final String TABLE_NAME="cse";
    public static final String COL1="name";
    public static final String COL2="email";
    public static final String COL3="branch";
    public static final String QUERY="create table if not exists "+TABLE_NAME+"("+COL1+" text,"+COL2+" text,"+COL3+" text)";
    public DBHelper(Context context)
    {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public long insertData(ContentValues values)
    {
        SQLiteDatabase db;
        db=getWritableDatabase();
        long i=db.insert(TABLE_NAME,null,values);
        return i;
    }
    public Cursor retrieveData()
    {
        SQLiteDatabase db;
        db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from "+TABLE_NAME,null);
        return c;
    }
}
