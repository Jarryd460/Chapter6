package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Patient;
import za.ac.cput.hospitalmanagementsystem.domain.Sex;

/**
 * Created by student on 2015/05/04.
 */
public class PatientFactory {

    public static Patient createPatient(Long id, String firstName, String lastName, Sex sex, int age, int contactNumber, String address) {

        Patient patient = new Patient.Builder(id).firstName(firstName).lastName(lastName).sex(sex).age(age).contactNumber(contactNumber).address(address).build();
        return patient;

    }

}
