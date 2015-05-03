package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/23.
 */
public class testAppointment {

    private Appointment appointment1;
    private Appointment appointment2;
    private Appointment appointment3;

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

        appointment1 = new Appointment.Builder(1).patient(patient1).bill(bill1).build();
        appointment2 = new Appointment.Builder(2).patient(patient2).bill(bill2).build();
        appointment3 = appointment1;
    }

    @Test
    public void testAppointmentId() {
        Assert.assertEquals(1, appointment1.getId());
    }

    @Test
    public void testAppointmentPatient() {
        Assert.assertEquals(patient1, appointment1.getPatient());
    }

    @Test
    public void testAppointmentBill() {
        Assert.assertEquals(bill1, appointment1.getBill());
    }

    @Test
    public void testAppointmentEquality() {
        Assert.assertEquals(false, appointment1.equals(appointment2));
        Assert.assertEquals(true, appointment1.equals(appointment3));
    }
}
