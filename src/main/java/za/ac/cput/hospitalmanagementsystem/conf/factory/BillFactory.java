package za.ac.cput.hospitalmanagementsystem.conf.factory;

import za.ac.cput.hospitalmanagementsystem.domain.Bill;

/**
 * Created by student on 2015/05/04.
 */
public class BillFactory {

    public static Bill createBill(int amount) {

        Bill bill = new Bill.Builder(amount).build();
        return bill;

    }

}
