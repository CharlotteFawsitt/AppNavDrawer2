package com.example.n00146163.appnavdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.Sample.PatientAdapter;
import com.example.n00146163.appnavdrawer.Sample.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    List<Patient> patientList = SampleDataProvider.patientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

       // long numPatients = mDataSource.getPatientCount();
        //Sort the list alphabetically
        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient patient, Patient t1) {
                Log.d("log", "patient list activity");
                return patient.getName().compareTo(t1.getName());
            }
        });


        PatientAdapter adapter = new PatientAdapter(this, patientList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }
}
