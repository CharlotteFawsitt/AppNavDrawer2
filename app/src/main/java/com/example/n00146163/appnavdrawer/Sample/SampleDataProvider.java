package com.example.n00146163.appnavdrawer.Sample;

import com.example.n00146163.appnavdrawer.Model.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by n00146163 on 21/11/2017.
 */

public class SampleDataProvider {

    public static List<Patient> dataItemList;
    public static Map<String, Patient> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new Patient(null, "John", "Male", "0865342516", "12/05/2018 12.45"));
        addItem(new Patient(null, "Frank", "Male", "0865342516", "12/05/2018 12.45"));
        addItem(new Patient(null, "James", "Male", "0865342516", "12/05/2018 12.45"));
        addItem(new Patient(null, "Jeremy", "Male", "0865342516", "12/05/2018 12.45"));
        addItem(new Patient(null, "Mark", "Male", "0865342516", "12/05/2018 12.45"));
        addItem(new Patient(null, "Dean", "Male", "0865342516", "12/05/2018 12.45"));
        addItem(new Patient(null, "Sam", "Male", "0865342516", "12/05/2018 12.45"));
    }

    private static void addItem(Patient patient) {
        dataItemList.add(patient);
        dataItemMap.put(patient.getPatientId(), patient);
    }
}
