package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Patient;
import za.ac.cput.hospitalmanagementsystem.domain.Ward;

import java.util.List;

/**
 * Created by student on 2015/05/04.
 */
public class WardFactory {

    public static Ward createPediatrician(Long id, int capacity, List<Patient> patientList) {

        Ward ward = new Ward.Builder(id).capacity(capacity).patients(patientList).build();
        return ward;

    }

}
