package za.ac.cput.hospitalmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalmanagementsystem.domain.Appointment;

/**
 * Created by student on 2015/05/01.
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    public Appointment findByCode(String code);

}
