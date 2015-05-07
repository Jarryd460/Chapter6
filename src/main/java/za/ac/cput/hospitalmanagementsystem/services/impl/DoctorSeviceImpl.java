package za.ac.cput.hospitalmanagementsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalmanagementsystem.domain.Doctor;
import za.ac.cput.hospitalmanagementsystem.repository.DoctorRepository;
import za.ac.cput.hospitalmanagementsystem.services.DoctorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@Service
public class DoctorSeviceImpl implements DoctorService {
    @Autowired
    DoctorRepository repository;

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> allDoctors = new ArrayList<Doctor>();

        Iterable<Doctor> doctors = repository.findAll();
        for (Doctor doctor : doctors) {
            allDoctors.add(doctor);
        }
        return allDoctors;
    }
}