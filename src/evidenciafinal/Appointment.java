/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evidenciafinal;

import java.util.Date;

/**
 *
 * @author PriscillaMilanesa
 */
class Appointment {
private int id;
private String date;
private String time;
private Doctor doctor;
private Patient patient;
private double amount;

public Appointment(int id, String date, String time, Doctor doctor, Patient patient, double amount) {
    this.id = id;
    this.date = date;
    this.time = time;
    this.doctor = doctor;
    this.patient = patient;
    this.amount = amount;
}

public int getId() {
    return id;
}

public String getDate() {
    return date;
}

public String getTime() {
    return time;
}

public Doctor getDoctor() {
    return doctor;
}

public Patient getPatient() {
    return patient;
}

public double getAmount() {
    return amount;
}
}