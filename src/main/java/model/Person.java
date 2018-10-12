package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author lyner
 */
@Data
@Entity
@Table(name = "Person")
public class Person {

        @Id
        @NotNull

        @Column(name = "name")
        private String name;

        @Column(name = "age")
        private int age;

        @Enumerated(EnumType.STRING)
        private String status;

        @Column(name ="birthDate")
        private Date birthDate;

        @Column(name = "selfDescription")
        private String selfDescription;

}
