package za.ac.cput.hospitalmanagementsystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalmanagementsystem.App;
import za.ac.cput.hospitalmanagementsystem.domain.Ward;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudWard {

    private Long id;

    @Autowired
    WardRepository repository;
    @Test
    public void testCreate() throws Exception {
        Ward ward = new Ward.Builder(new Long(1)).capacity(20).build();
        repository.save(ward);
        id = ward.getId();
        Assert.assertNotNull(ward.getId());
    }

    @Test//(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Ward ward = repository.findOne(id);
        Assert.assertEquals(20,ward.getCapacity());
    }

    @Test//(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Ward ward = repository.findOne(id);
        Ward newWard = new Ward.Builder(ward.getId()).capacity(23).build();
        repository.save(newWard);
        Assert.assertEquals(ward.getId(), newWard.getId());
        Assert.assertEquals(23, newWard.getCapacity());
    }

    @Test//(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Ward ward = repository.findOne(id);
        repository.delete(ward);
        Ward newWard = repository.findOne(id);
        Assert.assertNull(newWard);
    }

}
