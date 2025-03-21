package org.hospital.service;

import org.hospital.model.Appointment;
import org.hospital.util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    public void scheduleAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (appointment_id, patient_id, doctor_id, date, time, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointment.getAppointmentId());
            statement.setInt(2, appointment.getPatientId());
            statement.setInt(3, appointment.getDoctorId());
            statement.setString(4, appointment.getDate());
            statement.setString(5, appointment.getTime());
            statement.setString(6, appointment.getStatus());
            statement.executeUpdate();
            System.out.println("Appointment scheduled successfully!");
        } catch (SQLException e) {
            System.out.println("Error scheduling appointment: " + e.getMessage());
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getInt("appointment_id"),
                        resultSet.getInt("patient_id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getString("date"),
                        resultSet.getString("time"),
                        resultSet.getString("status")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        }
        return appointments;
    }

    public Appointment getAppointmentById(int appointmentId) {
        String query = "SELECT * FROM appointments WHERE appointment_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointmentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Appointment(
                            resultSet.getInt("appointment_id"),
                            resultSet.getInt("patient_id"),
                            resultSet.getInt("doctor_id"),
                            resultSet.getString("date"),
                            resultSet.getString("time"),
                            resultSet.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching appointment: " + e.getMessage());
        }
        return null;
    }
}