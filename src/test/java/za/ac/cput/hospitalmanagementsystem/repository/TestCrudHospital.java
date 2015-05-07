package za.ac.cput.hospitalmanagementsystem.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalmanagementsystem.App;
import za.ac.cput.hospitalmanagementsystem.domain.Hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudHospital {

    private String name;

    @Autowired
    HospitalRepository repository;
    @Test
    public void testCreate() throws Exception {
        Hospital hospital = new Hospital.Builder("hospital1").address("My street").build();
        repository.save(hospital);
        name = hospital.getName();
        Assert.assertNotNull(hospital.getName());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Hospital hospital = repository.findOne(name);
        Assert.assertEquals("My street",hospital.getAddress());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Hospital hospital = repository.findOne(name);
        Hospital newHospital = new Hospital.Builder(hospital.getName()).address("Your street").build();
        repository.save(newHospital);
        Assert.assertEquals(hospital.getName(), newHospital.getName());
        Assert.assertEquals("Your street", newHospital.getAddress());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Hospital hospital = repository.findOne(name);
        repository.delete(hospital);
        Hospital newHospital = repository.findOne(name);
        Assert.assertNull(newHospital);
    }
}
