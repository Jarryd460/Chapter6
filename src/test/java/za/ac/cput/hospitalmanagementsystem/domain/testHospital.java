package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/22.
 */
public class testHospital {
    private Hospital hospital1;
    private Hospital hospital2;
    private Hospital hospital3;

    private List<Ward> listWards1;
    private List<Ward> listWards2;

    private Ward ward1;
    private Ward ward2;
    private Ward ward3;
    private Ward ward4;

    @Before
    public void setUp() {
        listWards1 = new ArrayList<Ward>();
        listWards2 = new ArrayList<Ward>();

        ward1 = new Ward.Builder(new Long(1)).capacity(20).build();
        ward2 = new Ward.Builder(new Long(5)).capacity(13).build();
        ward3 = new Ward.Builder(new Long(3)).capacity(21).build();
        ward4 = new Ward.Builder(new Long(4)).capacity(17).build();

        listWards1.add(ward1);
        listWards1.add(ward2);
        listWards2.add(ward3);
        listWards2.add(ward4);

        hospital1 = new Hospital.Builder("hospital1").address("My street").wards(listWards1).build();
        hospital2 = new Hospital.Builder("hospital2").address("Your Street").wards(listWards2).build();
        hospital3 = hospital1;
    }

    @Test
    public void testHospitalName() {
        Assert.assertEquals("hospital1", hospital1.getName());
    }

    @Test
    public void testHospitalAddress() {
        Assert.assertEquals("My street", hospital1.getAddress());
    }

    @Test
    public void testHospitalWards() {
        Assert.assertEquals(listWards1, hospital1.getWards());
        Assert.assertEquals(listWards2, hospital2.getWards());
    }

    @Test
    public void testHospitalEquality() {
        Assert.assertEquals(false, hospital1.equals(hospital2));
        Assert.assertEquals(true, hospital1.equals(hospital3));
    }
}
