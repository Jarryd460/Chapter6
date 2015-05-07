package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/20.
 */
public class testPatient {

    private Patient patient1;
    private Patient patient2;
    private Patient patient3;

    @Before
    public void setUp() {
        patient1 = new Patient.Builder(new Long(5)).firstName("Jarryd").lastName("Deane").age(22).sex(Sex.Male).contactNumber(123456789).address("My Street").build();
        patient2 = new Patient.Builder(new Long(10)).firstName("Peter").lastName("Pan").sex(Sex.Male).contactNumber(987654321).address("Your Street").build();
        patient3 = patient1;
    }

    @Test
    public void testPatientId() {
        Long id = new Long(5);
        Assert.assertEquals(id, patient1.getId());
    }

    @Test
    public void testPatientFirstName() {
        Assert.assertEquals("Jarryd", patient1.getFirstName());
    }

    @Test
    public void testPatientLastName() {
        Assert.assertEquals("Deane", patient1.getLastName());
    }

    @Test
    public void testPatientAge() {
        Assert.assertEquals(22, patient1.getAge());
    }

    @Test
    public void testPatientSex() {
        Assert.assertEquals(Sex.Male, patient1.getSex());
    }

    @Test
    public void testPatientContactNumber() {
        Assert.assertEquals(123456789, patient1.getContactNumber());
    }

    @Test
    public void testPatientAddress() {
        Assert.assertEquals("My Street", patient1.getAddress());
    }

    @Test
    public void testPatientEquality() {
        Assert.assertEquals(false, patient1.equals(patient2));
        Assert.assertEquals(true, patient1.equals(patient3));
    }
}
