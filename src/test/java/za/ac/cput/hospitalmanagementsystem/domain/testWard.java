package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/23.
 */
public class testWard {

    private Ward ward1;
    private Ward ward2;
    private Ward ward3;

    private Patient patient1;
    private Patient patient2;
    private Patient patient3;

    private List<Patient> patientList1;
    private List<Patient> patientList2;

    @Before
    public void setUp() {
        patientList1 = new ArrayList<Patient>();
        patientList2 = new ArrayList<Patient>();

        patient1 = new Patient.Builder(new Long(5)).firstName("Jarryd").lastName("Deane").age(22).sex(Sex.Male).contactNumber(123456789).address("My Street").build();
        patient2 = new Patient.Builder(new Long(10)).firstName("Peter").lastName("Pan").sex(Sex.Male).contactNumber(987654321).address("Your Street").build();
        patient3 = patient1;

        patientList1.add(patient1);
        patientList1.add(patient2);
        patientList2.add(patient3);

        ward1 = new Ward.Builder(new Long(1)).capacity(20).patients(patientList1).build();
        ward2 = new Ward.Builder(new Long(2)).capacity(23).patients(patientList2).build();
        ward3 = ward1;
    }

    @Test
    public void testWardId() {
        Long id = new Long(1);
        Assert.assertEquals(id, ward1.getId());
    }

    @Test
    public void testWardCapacity() {
        Assert.assertEquals(20, ward1.getCapacity());
    }

    @Test
    public void testWardPatients() {
        Assert.assertEquals(patientList1, ward1.getPatients());
        Assert.assertEquals(patientList2, ward2.getPatients());
    }
}
