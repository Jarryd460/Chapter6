package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/23.
 */
public class testPediatrician {

    private Pediatrician Pediatrician1;
    private Pediatrician Pediatrician2;
    private Pediatrician Pediatrician3;

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
        patient1 = new Patient.Builder(5).firstName("Jarryd").lastName("Deane").age(22).sex(Sex.Male).contactNumber(123456789).address("My Street").build();
        patient2 = new Patient.Builder(10).firstName("Peter").lastName("Pan").sex(Sex.Male).contactNumber(987654321).address("Your Street").build();

        bill1 = new Bill.Builder(10000).build();
        bill2 = new Bill.Builder(25000).build();

        appointmentList1 = new ArrayList<Appointment>();
        appointmentList2 = new ArrayList<Appointment>();

        appointment1 = new Appointment.Builder(1).patient(patient1).bill(bill1).build();
        appointmentList1.add(appointment1);
        appointment2 = new Appointment.Builder(2).patient(patient2).bill(bill2).build();
        appointmentList2.add(appointment2);

        Pediatrician1 = new Pediatrician.Builder(1).firstName("Oliver").lastName("Khan").appointments(appointmentList1).build();
        Pediatrician2 = new Pediatrician.Builder(2).firstName("Ronald").lastName("Macdonald").appointments(appointmentList2).build();
        Pediatrician3 = Pediatrician1;
    }

    @Test
    public void testSurgeonId() {
        Assert.assertEquals(1, Pediatrician1.getId());
    }

    @Test
    public void testSurgeonFirstName() {
        Assert.assertEquals("Oliver", Pediatrician1.getFirstName());
    }

    @Test
    public void testSurgeonLastName() {
        Assert.assertEquals("Khan", Pediatrician1.getLastName());
    }

    @Test
    public void testSurgeonSpecialization() {
        Assert.assertEquals("Pediatrician", Pediatrician1.getSpecialization());
    }

    @Test
    public void testSurgeonAppointments() {
        Assert.assertEquals(appointmentList1, Pediatrician1.getAppointments());
    }

    @Test
    public void testSurgeonEquality() {
        Assert.assertEquals(false, Pediatrician1.equals(Pediatrician2));
        Assert.assertEquals(true, Pediatrician1.equals(Pediatrician3));
    }

}
