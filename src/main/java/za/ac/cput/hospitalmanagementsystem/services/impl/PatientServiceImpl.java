package za.ac.cput.hospitalmanagementsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hospitalmanagementsystem.domain.Patient;
import za.ac.cput.hospitalmanagementsystem.repository.PatientRepository;
import za.ac.cput.hospitalmanagementsystem.services.PatientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository repository;

    @Override
    public List<Patient> getPatients() {
        List<Patient> allPatients = new ArrayList<Patient>();

        Iterable<Patient> patients = repository.findAll();
        for (Patient patient : patients) {
            allPatients.add(patient);
        }
        return allPatients;
    }
}