package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class Bill implements Serializable {

    private int amount;

    private Bill() {

    }

    public Bill(Builder builder) {
        this.amount = builder.amount;
    }

    public int getAmount() {
        return amount;
    }

    public static class Builder {
        private int amount;

        public Builder(int amount) {
            this.amount = amount;
        }

        public Builder copy(Bill bill) {
            this.amount = bill.amount;
            return this;
        }

        public Bill build() {
            return new Bill(this);
        }
    }
}
