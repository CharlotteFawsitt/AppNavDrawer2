package com.example.n00146163.appnavdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.Sample.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    List<Patient> patientList = SampleDataProvider.dataItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        //Sort the list alphabetically
        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient patient, Patient t1) {
                return patient.getName().compareTo(t1.getName());
            }
        });

        //get a reference to the textview

        TextView tv = (TextView) findViewById(R.id.textView2);

        //loop through the patient list appending the name to the textview

        for(Patient p : patientList)
            tv.append("\n" + p.getName());
    }
}
