package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Appointment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Patient patient;
    @Embedded
    private Bill bill;

    private Appointment() {

    }

    public Appointment(Builder builder) {
        this.id = builder.id;
        this.patient = builder.patient;
        this.bill = builder.bill;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Bill getBill() {
        return bill;
    }

    public static class Builder {
        private Long id;
        private Patient patient;
        private Bill bill;

        public Builder(Long id) {
            this.id = id;
        }

        public Builder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder bill(Bill bill) {
            this.bill = bill;
            return this;
        }

        public Builder copy(Appointment appointment) {
            this.id = appointment.id;
            this.patient = appointment.patient;
            this.bill = appointment.bill;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;

        Appointment appointment = (Appointment) o;

        return !(id != null ? !id.equals(appointment.id) : appointment.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", bill=" + bill +
                '}';
    }

}
