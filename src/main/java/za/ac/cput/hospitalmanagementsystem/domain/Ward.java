package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Ward implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int capacity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ward_id")
    private List<Patient> patients;

    private Ward() {

    }

    public Ward(Builder builder) {
        this.id = builder.id;
        this.capacity = builder.capacity;
        this.patients = builder.patients;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public static class Builder {
        private int id;
        private int capacity;
        private List<Patient> patients;

        public Builder(int id) {
            this.id = id;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder patients(List<Patient> patients) {
            this.patients = patients;
            return this;
        }

        public Builder copy(Ward ward) {
            this.id = ward.id;
            this.capacity = ward.capacity;
            this.patients = ward.patients;
            return this;
        }

        public Ward build() {
            return new Ward(this);
        }
    }
}
