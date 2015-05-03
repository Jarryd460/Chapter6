package za.ac.cput.hospitalmanagementsystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalmanagementsystem.App;
import za.ac.cput.hospitalmanagementsystem.domain.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudPatient {

    private int id;

    @Autowired
    PatientRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Patient> patientList = new ArrayList<Patient>();
        Patient patient = new Patient.Builder(5).firstName("Jarryd").lastName("Deane").age(22).contactNumber(123456789).address("My Street").build();
        repository.save(patient);
        id = patient.getId();
        Assert.assertNotNull(patient.getId());
    }

    @Test
    public void testRead() throws Exception {
        Patient patient = repository.findOne(id);
        Assert.assertEquals("Jarryd",patient.getFirstName());
    }

    @Test
    public void testUpdate() throws Exception {
        Patient patient = repository.findOne(id);
        Patient newPatient = new Patient.Builder(10).firstName("Peter").lastName("Pan").contactNumber(987654321).address("Your Street").build();
        repository.save(newPatient);
        Assert.assertEquals(10, patient.getId());
        Assert.assertEquals("Peter", patient.getFirstName());
    }

    @Test
    public void testDelete() throws Exception {
        Patient patient = repository.findOne(id);
        repository.delete(patient);
        Patient newPatient = repository.findOne(id);
        Assert.assertNull(newPatient);
    }

}
