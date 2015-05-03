package za.ac.cput.hospitalmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalmanagementsystem.domain.Doctor;

/**
 * Created by student on 2015/05/01.
 */
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    public Doctor findByCode(String code);

}
