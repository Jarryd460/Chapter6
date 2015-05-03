package za.ac.cput.hospitalmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalmanagementsystem.domain.Hospital;

/**
 * Created by student on 2015/05/01.
 */
public interface HospitalRepository extends CrudRepository<Hospital, String> {

    public Hospital findByCode(String code);

}
