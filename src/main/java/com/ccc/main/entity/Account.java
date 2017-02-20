package com.ccc.main.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

import com.ccc.main.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

@Entity
@FilterDef(name="activeAccount", parameters=@ParamDef( name="active", type="boolean" ) )
@Filter(name="activeAccount", condition="active = :active")
@Where( clause = "active = true" )
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    public String password;

    public String username;

    @ManyToOne
    private Client client;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType type;

    private Double credit;

    private Double rate;

    @Formula(value = "credit * rate")
    private Double interest;


    public Account(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public Account() {
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
