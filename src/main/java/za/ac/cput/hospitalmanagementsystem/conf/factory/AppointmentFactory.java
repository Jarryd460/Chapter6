package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Appointment;
import za.ac.cput.hospitalmanagementsystem.domain.Bill;
import za.ac.cput.hospitalmanagementsystem.domain.Patient;

/**
 * Created by student on 2015/05/04.
 */
public class AppointmentFactory {

    public static Appointment createAppointment(Long id, Patient patient, Bill bill) {

        Appointment appointment = new Appointment.Builder(id).patient(patient).bill(bill).build();
        return appointment;

    }

}
