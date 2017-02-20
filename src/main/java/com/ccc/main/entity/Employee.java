package com.ccc.main.entity;

import javax.persistence.*;
import java.util.ArrayList;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.NaturalId;

@Entity(name = "Employee")
public class Employee {

    @Id
    private Long id;

    @NaturalId
    private String username;

    @Column(name = "pswd")
    @ColumnTransformer(
            read = "decrypt( 'AES', '00', pswd  )",
            write = "encrypt('AES', '00', ?)"
    )
    private String password;

    private int accessLevel;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Department department;
//
//    @ManyToMany(mappedBy = "employees")
//    private List<Project> projects = new ArrayList<>();

    //Getters and setters omitted for brevity
}
