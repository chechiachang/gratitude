package com.ccc.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

@Entity(name = "Savings")
public class Savings {

    @Id
    private Long id;

    @Type(type = "org.hibernate.userguide.mapping.basic.MonetaryAmountUserType")
    @Columns(columns = {
            @Column(name = "money"),
            @Column(name = "currency")
    })
    @ColumnTransformer(
            forColumn = "money",
            read = "money / 100",
            write = "? * 100"
    )
    private Long wallet;

    //Getters and setters omitted for brevity

}