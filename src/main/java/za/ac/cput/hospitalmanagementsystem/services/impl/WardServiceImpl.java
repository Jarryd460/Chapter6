package za.ac.cput.hospitalmanagementsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hospitalmanagementsystem.domain.Ward;
import za.ac.cput.hospitalmanagementsystem.repository.WardRepository;
import za.ac.cput.hospitalmanagementsystem.services.WardService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
public class WardServiceImpl implements WardService {
    @Autowired
    WardRepository repository;

    @Override
    public List<Ward> getWards() {
        List<Ward> allWards = new ArrayList<Ward>();

        Iterable<Ward> wards = repository.findAll();
        for (Ward ward : wards) {
            allWards.add(ward);
        }
        return allWards;
    }
}