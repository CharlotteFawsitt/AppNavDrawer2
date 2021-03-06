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

    public static List<Patient> patientList;
    public static Map<String, Patient> patientMap;

    static {
        patientList = new ArrayList<>();
        patientMap = new HashMap<>();

        addItem(new Patient(null, "John", "Male", "0865342516", "12/05/2018 12.45", "ic_launcher.png"));
        addItem(new Patient(null, "Frank", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "James", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Jeremy", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Mark", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Dean", "Male", "0865342516", "12/05/2018 12.45", "ic_launcher.png"));
        addItem(new Patient(null, "Sam", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "John", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Frank", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "James", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Jeremy", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Mark", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Dean", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Sam", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "John", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Frank", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "James", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Jeremy", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Mark", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Dean", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
        addItem(new Patient(null, "Sam", "Male", "0865342516", "12/05/2018 12.45", "ic_hosp_image.png"));
    }

    private static void addItem(Patient patient) {
        patientList.add(patient);
        patientMap.put(patient.getPatientId(), patient);
    }
}
