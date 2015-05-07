package za.ac.cput.hospitalmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalmanagementsystem.domain.Patient;

/**
 * Created by student on 2015/05/01.
 */
public interface PatientRepository extends CrudRepository<Patient, Long> {

    public Patient findByCode(String code);

}
