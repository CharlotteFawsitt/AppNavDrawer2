package com.example.n00146163.appnavdrawer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.n00146163.appnavdrawer.Model.Patient;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by N00146163 on 28/11/2017.
 */

public class DataSource {

    DataSource mDataSource;
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

    public long getPatientCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, PatientsTable.TABLE_PATIENTS);
    }

        public void seedDatabase(List<Patient> patientList) {
        long numPatients = getPatientCount();
        if (numPatients == 0) {
            for (Patient patient : patientList) {
                try {
                    createPatient(patient);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Patient> getAllPatients(){
        List<Patient> patientList = new ArrayList<>();
        Cursor cursor = mDatabase.query(PatientsTable.TABLE_PATIENTS, PatientsTable.ALL_COLUMNS,
                null, null, null, null, PatientsTable.COLUMN_NAME);

        while (cursor.moveToNext()) {
            Patient patient = new Patient();
            patient.setPatientId(cursor.getString(
                    cursor.getColumnIndex(PatientsTable.COLUMN_ID)));
            patient.setName(cursor.getString(
                    cursor.getColumnIndex(PatientsTable.COLUMN_NAME)));
            patient.setGender(cursor.getString(
                    cursor.getColumnIndex(PatientsTable.COLUMN_GENDER)));
            patient.setPhoneNumber(cursor.getString(
                    cursor.getColumnIndex(PatientsTable.COLUMN_PHONENUMBER)));
            patient.setNextApp(cursor.getString(
                    cursor.getColumnIndex(PatientsTable.COLUMN_NEXT_APP)));

            patientList.add(patient);
        }

        cursor.close();

        return patientList;
    }

    public int updatePatient(Patient patient){
        ContentValues values = patient.toValues();
        int result = mDatabase.update(PatientsTable.TABLE_PATIENTS, values, "PatientId = ?", new String[] {patient.getPatientId()});
        return result;
    }

    public boolean insertPatient(String name, String gender, String phoneNumber, String nextApp) {

        ContentValues contentValues = new ContentValues();
        String pId = null;
        if(pId == null){
            pId = UUID.randomUUID().toString();
        }
        contentValues.put(PatientsTable.COLUMN_ID, pId);
        contentValues.put(PatientsTable.COLUMN_NAME, name);
        contentValues.put(PatientsTable.COLUMN_GENDER, gender);
        contentValues.put(PatientsTable.COLUMN_PHONENUMBER, phoneNumber);
        contentValues.put(PatientsTable.COLUMN_NEXT_APP, nextApp);

        long result = mDatabase.insert(PatientsTable.TABLE_PATIENTS, null, contentValues);

        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deletePatient(Patient patient) {
        mDatabase.delete(PatientsTable.TABLE_PATIENTS,"PatientId = ?", new String[] {patient.getPatientId()});
    }


}
