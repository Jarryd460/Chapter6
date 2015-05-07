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

    private Long id;

    @Autowired
    DoctorRepository repository;
    @Test
    public void testCreate() throws Exception {
        Doctor doctor = new Surgeon.Builder(new Long(1)).firstName("Oliver").lastName("Khan").build();
        repository.save(doctor);
        id = doctor.getId();
        Assert.assertNotNull(doctor.getId());
    }

    @Test//(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Doctor doctor = repository.findOne(id);
        Assert.assertEquals("Oliver",doctor.getFirstName());
    }

    @Test//(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Doctor doctor = repository.findOne(id);
        Doctor newDoctor = new Surgeon.Builder(doctor.getId()).firstName("Ronald").lastName("Macdonald").build();
        repository.save(newDoctor);
        Assert.assertEquals(newDoctor.getId(), doctor.getId());
        Assert.assertEquals("Macdonald", newDoctor.getLastName());
    }

    @Test//(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Doctor doctor = repository.findOne(id);
        repository.delete(doctor);
        Doctor newDoctor = repository.findOne(id);
        Assert.assertNull(newDoctor);
    }

}
