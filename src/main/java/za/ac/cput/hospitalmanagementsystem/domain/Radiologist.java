package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Radiologist extends Doctor implements Serializable {

    private Radiologist() {
        super();
    }

    public Radiologist(Builder builder) {
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
        private String specialization = "Radiologist";
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

        public Builder copy(Radiologist radiologist) {
            this.id = radiologist.id;
            this.firstName = radiologist.firstName;
            this.lastName = radiologist.lastName;
            this.specialization = radiologist.specialization;
            this.appointments = radiologist.appointments;
            return this;
        }

        public Radiologist build() {
            return new Radiologist(this);
        }
    }
}
