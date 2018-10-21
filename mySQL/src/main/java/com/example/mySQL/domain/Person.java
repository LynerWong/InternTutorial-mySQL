package com.example.mySQL.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 *
 * @author lyner
 */
@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name="maritial")
    private String maritial;

    @Column(name ="birth")
    private Date birth;

    @Column(name = "description")
    private String description;
}