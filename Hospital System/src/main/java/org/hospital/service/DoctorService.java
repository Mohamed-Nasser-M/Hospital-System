package org.hospital.service;

import org.hospital.model.Doctor;
import org.hospital.util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (doctor_id, name, specialization, contact_info, availability) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctor.getDoctorId());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSpecialization());
            statement.setString(4, doctor.getContactInfo());
            statement.setString(5, doctor.getAvailability());
            statement.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("doctor_id"),
                        resultSet.getString("name"),
                        resultSet.getString("specialization"),
                        resultSet.getString("contact_info"),
                        resultSet.getString("availability")
                );
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching doctors: " + e.getMessage());
        }
        return doctors;
    }

    public Doctor getDoctorById(int doctorId) {
        String query = "SELECT * FROM doctors WHERE doctor_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Doctor(
                            resultSet.getInt("doctor_id"),
                            resultSet.getString("name"),
                            resultSet.getString("specialization"),
                            resultSet.getString("contact_info"),
                            resultSet.getString("availability")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching doctor: " + e.getMessage());
        }
        return null;
    }
}