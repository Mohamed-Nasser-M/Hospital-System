package org.hospital.model;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String contactInfo;
    private String availability;

    public Doctor(int doctorId, String name, String specialization, String contactInfo, String availability) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.contactInfo = contactInfo;
        this.availability = availability;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId +
                "\nName: " + name +
                "\nSpecialization: " + specialization +
                "\nContact Info: " + contactInfo +
                "\nAvailability: " + availability;
    }
}