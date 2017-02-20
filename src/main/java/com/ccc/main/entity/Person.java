package com.ccc.main.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;

import com.ccc.main.enums.Gender;
import com.ccc.main.hbm.GenderConverter;

@Entity(name = "Person")
public class Person {

    private Long id;

    private String name;

    @Convert(converter = GenderConverter.class)
    public Gender gender;
}
