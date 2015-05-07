package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/23.
 */
public class testRadiologist {

    private Radiologist Radiologist1;
    private Radiologist Radiologist2;
    private Radiologist Radiologist3;

    private Appointment appointment1;
    private Appointment appointment2;

    private List<Appointment> appointmentList1;
    private List<Appointment> appointmentList2;

    private Patient patient1;
    private Patient patient2;

    private Bill bill1;
    private Bill bill2;

    @Before
    public void setUp() {
        patient1 = new Patient.Builder(new Long(5)).firstName("Jarryd").lastName("Deane").age(22).sex(Sex.Male).contactNumber(123456789).address("My Street").build();
        patient2 = new Patient.Builder(new Long(10)).firstName("Peter").lastName("Pan").sex(Sex.Male).contactNumber(987654321).address("Your Street").build();

        bill1 = new Bill.Builder(10000).build();
        bill2 = new Bill.Builder(25000).build();

        appointmentList1 = new ArrayList<Appointment>();
        appointmentList2 = new ArrayList<Appointment>();

        appointment1 = new Appointment.Builder(new Long(1)).patient(patient1).bill(bill1).build();
        appointmentList1.add(appointment1);
        appointment2 = new Appointment.Builder(new Long(2)).patient(patient2).bill(bill2).build();
        appointmentList2.add(appointment2);

        Radiologist1 = new Radiologist.Builder(new Long(1)).firstName("Oliver").lastName("Khan").appointments(appointmentList1).build();
        Radiologist2 = new Radiologist.Builder(new Long(2)).firstName("Ronald").lastName("Macdonald").appointments(appointmentList2).build();
        Radiologist3 = Radiologist1;
    }

    @Test
    public void testSurgeonId() {
        Long id = new Long(1);
        Assert.assertEquals(id, Radiologist1.getId());
    }

    @Test
    public void testSurgeonFirstName() {
        Assert.assertEquals("Oliver", Radiologist1.getFirstName());
    }

    @Test
    public void testSurgeonLastName() {
        Assert.assertEquals("Khan", Radiologist1.getLastName());
    }

    @Test
    public void testSurgeonSpecialization() {
        Assert.assertEquals("Radiologist", Radiologist1.getSpecialization());
    }

    @Test
    public void testSurgeonAppointments() {
        Assert.assertEquals(appointmentList1, Radiologist1.getAppointments());
    }

    @Test
    public void testSurgeonEquality() {
        Assert.assertEquals(false, Radiologist1.equals(Radiologist2));
        Assert.assertEquals(true, Radiologist1.equals(Radiologist3));
    }
}
