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

    private int id;

    @Autowired
    WardRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Ward> wardList = new ArrayList<Ward>();
        Ward ward = new Ward.Builder(1).capacity(20).build();
        repository.save(ward);
        id = ward.getId();
        Assert.assertNotNull(ward.getId());
    }

    @Test
    public void testRead() throws Exception {
        Ward ward = repository.findOne(id);
        Assert.assertEquals(20,ward.getCapacity());
    }

    @Test
    public void testUpdate() throws Exception {
        Ward ward = repository.findOne(id);
        Ward newWard = new Ward.Builder(2).capacity(23).build();
        repository.save(newWard);
        Assert.assertEquals(23, ward.getCapacity());
        Assert.assertEquals(2, ward.getId());
    }

    @Test
    public void testDelete() throws Exception {
        Ward ward = repository.findOne(id);
        repository.delete(ward);
        Ward newWard = repository.findOne(id);
        Assert.assertNull(newWard);
    }

}
