package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Hospital implements Serializable {

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="hospital_name")
    private List<Ward> wards;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="hospital_name")
    private List<Doctor> doctors;

    private Hospital() {

    }

    public Hospital(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.wards = builder.wards;
        this.doctors = builder.doctors;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public static class Builder {
        private String name;
        private String address;
        private List<Ward> wards;
        private List<Doctor> doctors;

        public Builder(String name) {
            this.name = name;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder wards(List<Ward> wards) {
            this.wards = wards;
            return this;
        }

        public Builder doctors(List<Doctor> doctors) {
            this.doctors = doctors;
            return this;
        }

        public Builder copy(Hospital hospital) {
            this.name = hospital.name;
            this.address = hospital.address;
            this.wards = hospital.wards;
            this.doctors = hospital.doctors;
            return this;
        }

        public Hospital build() {
            return new Hospital(this);
        }

    }
}
