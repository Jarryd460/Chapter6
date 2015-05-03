package za.ac.cput.hospitalmanagementsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */

@Embeddable
public enum Sex implements Serializable {
    Male, Female
}
