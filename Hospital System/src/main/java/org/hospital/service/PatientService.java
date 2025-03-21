package org.hospital.service;

import org.hospital.model.Patient;
import org.hospital.util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (patient_id, name, age, gender, contact_info, medical_history) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patient.getPatientId());
            statement.setString(2, patient.getName());
            statement.setInt(3, patient.getAge());
            statement.setString(4, patient.getGender());
            statement.setString(5, patient.getContactInfo());
            statement.setString(6, patient.getMedicalHistory());
            statement.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getInt("patient_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("contact_info"),
                        resultSet.getString("medical_history")
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        return patients;
    }
}