package com.ccc.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    private Date timestamp;

    public Event() {}

    public Long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}