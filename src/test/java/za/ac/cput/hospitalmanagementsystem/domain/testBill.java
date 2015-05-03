package za.ac.cput.hospitalmanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/23.
 */
public class testBill {

    private Bill bill1;
    private Bill bill2;
    private Bill bill3;

    @Before
    public void setUp() {
        bill1 = new Bill.Builder(10000).build();
        bill2 = new Bill.Builder(25000).build();
        bill3 = bill1;
    }

    @Test
    public void testBillAmount() {
        Assert.assertEquals(10000, bill1.getAmount());
        Assert.assertEquals(25000, bill2.getAmount());
    }

    @Test
    public void testBillEquality() {
        Assert.assertEquals(false, bill1.equals(bill2));
        Assert.assertEquals(true, bill1.equals(bill3));
    }

}
