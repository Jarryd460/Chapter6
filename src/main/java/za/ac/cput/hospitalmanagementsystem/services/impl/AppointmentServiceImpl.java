package za.ac.cput.hospitalmanagementsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hospitalmanagementsystem.domain.Appointment;
import za.ac.cput.hospitalmanagementsystem.repository.AppointmentRepository;
import za.ac.cput.hospitalmanagementsystem.services.AppointmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository repository;

    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> allAppointments = new ArrayList<Appointment>();

        Iterable<Appointment> appointments = repository.findAll();
        for (Appointment appointment : appointments) {
            allAppointments.add(appointment);
        }
        return allAppointments;
    }
}
