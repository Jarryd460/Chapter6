package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Appointment;
import za.ac.cput.hospitalmanagementsystem.domain.Radiologist;

import java.util.List;

/**
 * Created by student on 2015/05/04.
 */
public class RadiologistFactory {

    public static Radiologist createRadiologist(Long id, String firstName, String lastName, List<Appointment> appointmentList) {

        Radiologist radiologist = new Radiologist.Builder(id).firstName(firstName).lastName(lastName).appointments(appointmentList).build();
        return radiologist;

    }

}
