package za.ac.cput.hospitalmanagementsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalmanagementsystem.domain.Hospital;
import za.ac.cput.hospitalmanagementsystem.repository.HospitalRepository;
import za.ac.cput.hospitalmanagementsystem.services.HospitalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@Service
public class HospitalServiceImpl implements HospitalService{
    @Autowired
    HospitalRepository repository;

    @Override
    public List<Hospital> getHospitals() {
        List<Hospital> allHospitals = new ArrayList<Hospital>();

        Iterable<Hospital> hospitals = repository.findAll();
        for (Hospital hospital : hospitals) {
            allHospitals.add(hospital);
        }
        return allHospitals;
    }


}
