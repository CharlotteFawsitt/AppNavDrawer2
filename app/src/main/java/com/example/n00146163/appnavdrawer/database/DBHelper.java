package com.example.n00146163.appnavdrawer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by N00146163 on 28/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "hospital.db";
    public static final int DB_VERSION = 6;
    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(PatientsTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(PatientsTable.SQL_DELETE);
        onCreate(sqLiteDatabase);
    }

}
