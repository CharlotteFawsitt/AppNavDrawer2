package com.example.n00146163.appnavdrawer.database;

/**
 * Created by N00146163 on 28/11/2017.
 */

public class PatientsTable {
    public static final String TABLE_PATIENTS = "patients";
    public static final String COLUMN_ID = "patientId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_NEXT_APP = "nextApp";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_GENDER,
                    COLUMN_PHONENUMBER, COLUMN_NEXT_APP};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_PATIENTS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_GENDER + " TEXT," +
                    COLUMN_PHONENUMBER + " TEXT," +
                    COLUMN_NEXT_APP + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_PATIENTS;
}
