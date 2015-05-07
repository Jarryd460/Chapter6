package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Doctor;
import za.ac.cput.hospitalmanagementsystem.domain.Hospital;
import za.ac.cput.hospitalmanagementsystem.domain.Patient;
import za.ac.cput.hospitalmanagementsystem.domain.Ward;

import java.util.List;

/**
 * Created by student on 2015/05/04.
 */
public class HospitalFactory {

    public static Hospital createHospital(String name, String address, List<Ward> wardList, List<Doctor> doctorList) {

        Hospital hospital = new Hospital.Builder(name).address(address).wards(wardList).doctors(doctorList).build();
        return hospital;

    }

}
