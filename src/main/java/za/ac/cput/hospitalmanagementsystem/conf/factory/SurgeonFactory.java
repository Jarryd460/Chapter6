package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Appointment;
import za.ac.cput.hospitalmanagementsystem.domain.Surgeon;

import java.util.List;

/**
 * Created by student on 2015/05/04.
 */
public class SurgeonFactory {

    public static Surgeon createSurgeon(Long id, String firstName, String lastName, List<Appointment> appointmentList) {

        Surgeon surgeon = new Surgeon.Builder(id).firstName(firstName).lastName(lastName).appointments(appointmentList).build();
        return surgeon;

    }

}
