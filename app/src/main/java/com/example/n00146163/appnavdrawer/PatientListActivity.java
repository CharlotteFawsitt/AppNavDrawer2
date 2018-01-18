package com.example.n00146163.appnavdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.Sample.SampleDataProvider;
import com.example.n00146163.appnavdrawer.database.DataSource;

import java.util.List;

public class PatientListActivity extends AppCompatActivity{
    List<Patient> patientList = SampleDataProvider.patientList;
    DataSource mDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(patientList);

        //Toast.makeText(this, "Database acquired", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_patient_list);


       // long numPatients = mDataSource.getPatientCount();
        //Sort the list alphabetically
//        Collections.sort(patientList, new Comparator<Patient>() {
//            @Override
//            public int compare(Patient patient, Patient t1) {
//                Log.d("log", "patient list activity");
//                return patient.getName().compareTo(t1.getName());
//            }
//        });

        List<Patient> listFromDB = mDataSource.getAllPatients();

        PatientAdapter adapter = new PatientAdapter(this, listFromDB);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patient_list_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, addActivity.class);
            startActivity(intent);
        }
        else{
            onBackPressed();
        }
            return true;
    }
    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();

        List<Patient> listFromDB = mDataSource.getAllPatients();

        PatientAdapter adapter = new PatientAdapter(this, listFromDB);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }

}
