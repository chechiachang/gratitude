package com.ccc.main.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.ccc.main.enums.PhoneType;


@Entity( name = "Phone")
public class Phone {

    @Id
    private Long id;

    private String number;

    @Enumerated(EnumType.ORDINAL)
    private PhoneType type;

    @Enumerated(EnumType.STRING)
    private PhoneType typeDesc;

    void demo(){
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setNumber("12345567");
        phone.setType(PhoneType.LAND_LINE);
        phone.setTypeDesc(PhoneType.LAND_LINE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public PhoneType getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(PhoneType typeDesc) {
        this.typeDesc = typeDesc;
    }
}
