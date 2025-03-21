package org.hospital;

import org.hospital.model.Appointment;
import org.hospital.model.Doctor;
import org.hospital.model.Patient;
import org.hospital.service.AppointmentService;
import org.hospital.service.DoctorService;
import org.hospital.service.PatientService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static PatientService patientService = new PatientService();
    private static DoctorService doctorService = new DoctorService();
    private static AppointmentService appointmentService = new AppointmentService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    scheduleAppointment();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter Medical History: ");
        String medicalHistory = scanner.nextLine();

        Patient patient = new Patient(patientId, name, age, gender, contactInfo, medicalHistory);
        patientService.addPatient(patient);
    }

    private static void viewPatients() {
        List<Patient> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
                System.out.println("-------------------");
            }
        }
    }

    private static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter Availability: ");
        String availability = scanner.nextLine();

        Doctor doctor = new Doctor(doctorId, name, specialization, contactInfo, availability);
        doctorService.addDoctor(doctor);
    }

    private static void viewDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
                System.out.println("-------------------");
            }
        }
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        int appointmentId = scanner.nextInt();
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Time (HH:MM AM/PM): ");
        String time = scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Appointment appointment = new Appointment(appointmentId, patientId, doctorId, date, time, status);
        appointmentService.scheduleAppointment(appointment);
    }

    private static void viewAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
                System.out.println("-------------------");
            }
        }
    }
}