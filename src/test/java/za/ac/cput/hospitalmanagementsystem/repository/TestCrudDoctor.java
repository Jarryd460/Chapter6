package za.ac.cput.hospitalmanagementsystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalmanagementsystem.App;
import za.ac.cput.hospitalmanagementsystem.domain.Doctor;
import za.ac.cput.hospitalmanagementsystem.domain.Surgeon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudDoctor {

    private int id;

    @Autowired
    DoctorRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Doctor> doctorList = new ArrayList<Doctor>();
        Doctor doctor = new Surgeon.Builder(1).firstName("Oliver").lastName("Khan").build();
        repository.save(doctor);
        id = doctor.getId();
        Assert.assertNotNull(doctor.getId());
    }

    @Test
    public void testRead() throws Exception {
        Doctor doctor = repository.findOne(id);
        Assert.assertEquals("Oliver",doctor.getFirstName());
    }

    @Test
    public void testUpdate() throws Exception {
        Doctor doctor = repository.findOne(id);
        Doctor newDoctor = new Surgeon.Builder(2).firstName("Ronald").lastName("Macdonald").build();
        repository.save(newDoctor);
        Assert.assertEquals("Ronald", doctor.getFirstName());
        Assert.assertEquals("Macdonald", doctor.getLastName());
    }

    @Test
    public void testDelete() throws Exception {
        Doctor doctor = repository.findOne(id);
        repository.delete(doctor);
        Doctor newDoctor = repository.findOne(id);
        Assert.assertNull(newDoctor);
    }

}
