package com.ccc.system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Where;

@Entity(name = "Client")
public class Client {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "client")
    @Filter(name="activeAccount", condition="active = :active")
    private List<Account> accounts = new ArrayList<>( );

    @Where( clause = "account_type = 'DEBIT'")
    @OneToMany(mappedBy = "client")
    private List<Account> debitAccounts = new ArrayList<>( );

    @Where( clause = "account_type = 'CREDIT'")
    @OneToMany(mappedBy = "client")
    private List<Account> creditAccounts = new ArrayList<>( );

    //Getters and setters omitted for brevity

}