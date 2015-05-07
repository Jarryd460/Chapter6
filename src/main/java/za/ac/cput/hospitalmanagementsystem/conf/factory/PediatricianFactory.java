package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Appointment;
import za.ac.cput.hospitalmanagementsystem.domain.Pediatrician;

import java.util.List;

/**
 * Created by student on 2015/05/04.
 */
public class PediatricianFactory {

    public static Pediatrician createPediatrician(Long id, String firstName, String lastName, List<Appointment> appointmentList) {

        Pediatrician pediatrician = new Pediatrician.Builder(id).firstName(firstName).lastName(lastName).appointments(appointmentList).build();
        return pediatrician;

    }

}
