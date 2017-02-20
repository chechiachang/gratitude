package com.ccc.main.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import com.ccc.main.enums.Gender;
import com.ccc.main.hbm.GenderConverter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity(name = "Person")
public class Person {

    private Long id;

    private String name;

    @Convert(converter = GenderConverter.class)
    public Gender gender;

    private String firstName;

    private String lastName;

    private String middleName1;

    private String middleName2;

    private String middleName3;

    private String middleName4;

    private String middleName5;

    @Generated( value = GenerationTime.ALWAYS )
    @Column(columnDefinition =
            "AS CONCAT(" +
                    "    COALESCE(firstName, ''), " +
                    "    COALESCE(' ' + middleName1, ''), " +
                    "    COALESCE(' ' + middleName2, ''), " +
                    "    COALESCE(' ' + middleName3, ''), " +
                    "    COALESCE(' ' + middleName4, ''), " +
                    "    COALESCE(' ' + middleName5, ''), " +
                    "    COALESCE(' ' + lastName, '') " +
                    ")")
    private String fullName;
}
