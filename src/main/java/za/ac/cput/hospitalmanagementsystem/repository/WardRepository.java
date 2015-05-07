package za.ac.cput.hospitalmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalmanagementsystem.domain.Ward;

/**
 * Created by student on 2015/05/01.
 */
public interface WardRepository extends CrudRepository<Ward, Long> {

    public Ward findByCode(String code);

}
