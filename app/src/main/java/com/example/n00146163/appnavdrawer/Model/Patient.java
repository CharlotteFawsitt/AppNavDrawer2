package com.example.n00146163.appnavdrawer.Model;

import java.util.ArrayList;

/**
 * Created by n00146163 on 21/11/2017.
 */

public class Patient {
    private String patientId;
    private String name;
    private String gender;
    private String phoneNumber;
    private String nextApp;
   // private ArrayList previousApps;

    public Patient (String pId, String n, String g, String pN, String nA) {
        this.patientId = pId;
        this.name = n;
        this.gender = g;
        this.phoneNumber = pN;
        this.nextApp = nA;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNextApp() {
        return nextApp;
    }

    public void setNextApp(String nextApp) {
        this.nextApp = nextApp;
    }

//    public ArrayList getPreviousApps() {
//        return previousApps;
//    }
//
//    public void setPreviousApps(ArrayList previousApps) {
//        this.previousApps = previousApps;
//    }
}
