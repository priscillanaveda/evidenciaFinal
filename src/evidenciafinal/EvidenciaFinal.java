/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evidenciafinal;

/**
 *
 * @author PriscillaMilanesa
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EvidenciaFinal {
    public static void main(String[] args) {
    List<User> users = new ArrayList<>();
    users.add(new User("admin", "admin"));

    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    User currentUser = null;

    while (currentUser == null) {
        System.out.println("Ingrese su usuario:");
        String username = scanner.next();

        System.out.println("Ingrese su contraseña:");
        String password = scanner.next();

        boolean foundUser = false;

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                foundUser = true;
                break;
            }
        }

        if (!foundUser) {
            System.out.println("Usuario y/o contraseña incorrectos.");
            continue;
        }

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Registrar cita");
            System.out.println("4. Ver citas programadas");
            System.out.println("5. Generar reporte de citas");
            System.out.println("6. Salir");

            int menuOption = scanner.nextInt();

            if (menuOption == 6) {
                System.out.println("Gracias por usar el sistema.");
                break;
            } else if (menuOption == 1) {
                System.out.println("Ingrese el ID del doctor:");
                int id = scanner.nextInt();

                System.out.println("Ingrese el nombre del doctor:");
                String name = scanner.next();

                doctors.add(new Doctor(id, name));

                System.out.println("Doctor registrado exitosamente.");
            } else if (menuOption == 2) {
                System.out.println("Ingrese el ID del paciente:");
                int id = scanner.nextInt();

                System.out.println("Ingrese el nombre del paciente:");
                String name = scanner.next();

                patients.add(new Patient(id, name));

                System.out.println("Paciente registrado exitosamente.");
            } else if (menuOption == 3) {
                System.out.println("Ingrese el ID de la cita:");
                int id = scanner.nextInt();

                System.out.println("Ingrese la fecha de la cita (dd/mm/aaaa):");
                String date = scanner.next();

                System.out.println("Ingrese la hora de la cita (hh:mm):");
                String time = scanner.next();

                System.out.println("Ingrese el ID del doctor:");
                int doctorId = scanner.nextInt();

                Doctor doctor = null;

                for (Doctor d : doctors) {
                    if (d.getId() == doctorId) {
                        doctor = d;
                        break;
                    }
                }

                if (doctor == null) {
                    System.out.println("El doctor no existe.");
                    continue;
                }

                System.out.println("Ingrese el ID del paciente:");
                int patientId = scanner.nextInt();

                Patient patient = null;

                for (Patient p : patients) {
                    if (p.getId() == patientId) {
                        patient = p;
                        break;
                    }
                }

                if (patient == null) {
                    System.out.println("El paciente no existe.");
                    continue;
                }

                System.out.println("Ingrese el monto de la cita:");
                double amount = scanner.nextDouble();

                appointments.add(new Appointment(id, date, time, doctor, patient, amount));

                System.out.println("Cita registrada exitosamente.");
            } else if (menuOption ==  4) {
            System.out.println("Citas programadas:");
            for (Appointment a : appointments) {
                    System.out.println("ID: " + a.getId());
                    System.out.println("Fecha: " + a.getDate());
                    System.out.println("Hora: " + a.getTime());
                    System.out.println("Doctor: " + a.getDoctor().getName());
                    System.out.println("Paciente: " + a.getPatient().getName());
                    System.out.println("Monto: " + a.getAmount());
                    System.out.println();
                }
            } else if (menuOption == 5) {
                System.out.println("Reporte de citas:");

                double totalAmount = 0;

                for (Appointment a : appointments) {
                    totalAmount += a.getAmount();
                }

                System.out.println("Total de citas programadas: " + appointments.size());
                System.out.println("Total recaudado: " + totalAmount);
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
    }
}
            

    
    
    
