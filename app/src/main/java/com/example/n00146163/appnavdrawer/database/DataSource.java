package com.example.n00146163.appnavdrawer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.n00146163.appnavdrawer.Model.Patient;

/**
 * Created by N00146163 on 28/11/2017.
 */

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }
    public Patient createPatient(Patient p) {
        ContentValues values = p.toValues();
        mDatabase.insert(PatientsTable.TABLE_PATIENTS, null, values);
        return p;
    }
}
