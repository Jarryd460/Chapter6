package za.ac.cput.hospitalmanagementsystem.services;

import za.ac.cput.hospitalmanagementsystem.domain.Appointment;

import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
public interface AppointmentService {

    List<Appointment> getAppointments();

}
