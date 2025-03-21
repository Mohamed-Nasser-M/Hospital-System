package org.hospital.model;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String contactInfo;
    private String medicalHistory;

    public Patient(int patientId, String name, int age, String gender, String contactInfo, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nContact Info: " + contactInfo +
                "\nMedical History: " + medicalHistory;
    }
}