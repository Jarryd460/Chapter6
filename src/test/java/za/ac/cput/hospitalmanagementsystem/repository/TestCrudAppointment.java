package za.ac.cput.hospitalmanagementsystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalmanagementsystem.App;
import za.ac.cput.hospitalmanagementsystem.domain.Appointment;
import za.ac.cput.hospitalmanagementsystem.domain.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudAppointment {

    private Long id;
    private Patient patient1;

    @Autowired
    AppointmentRepository repository;
    @Test
    public void testCreate() throws Exception {
        patient1 = new Patient.Builder(new Long(5)).firstName("Jarryd").lastName("Deane").age(22).contactNumber(123456789).address("My Street").build();
        Appointment appointment = new Appointment.Builder(new Long(1)).patient(patient1).build();
        repository.save(appointment);
        id = appointment.getId();
        Assert.assertNotNull(appointment.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Appointment appointment = repository.findOne(id);
        Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Appointment appointment = repository.findOne(id);
        Patient patient2 = new Patient.Builder(new Long(10)).firstName("Peter").lastName("Pan").contactNumber(987654321).address("Your Street").build();
        Appointment newAppointment = new Appointment.Builder(appointment.getId()).patient(patient2).build();
        repository.save(newAppointment);
        Assert.assertEquals(appointment.getId(), newAppointment.getId());
        Assert.assertEquals(patient2, newAppointment.getPatient());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Appointment appointment = repository.findOne(id);
        repository.delete(appointment);
        Appointment newAppointment = repository.findOne(id);
        Assert.assertNull(newAppointment);
    }

}
