package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Pediatrician extends Doctor implements Serializable {

    private Pediatrician() {
        super();
    }

    public Pediatrician(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.specialization = builder.specialization;
        this.appointments = builder.appointments;
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String specialization = "Pediatrician";
        private List<Appointment> appointments;

        public Builder(int id) {
            this.id = id;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder appointments(List<Appointment> appointments) {
            this.appointments = appointments;
            return this;
        }

        public Builder copy(Pediatrician pediatrician) {
            this.id = pediatrician.id;
            this.firstName = pediatrician.firstName;
            this.lastName = pediatrician.lastName;
            this.specialization = pediatrician.specialization;
            this.appointments = pediatrician.appointments;
            return this;
        }

        public Pediatrician build() {
            return new Pediatrician(this);
        }
    }

}
