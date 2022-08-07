package com.example.servingwebcontent.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class CustomerEntity {
    @Id                            //помечаем спрингу, что является id (идентификатором)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String customerName;
    private String password;

    private String lastName;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<BillEntity> bills;   // создаем список счетов, чтобы связать с сущностью Bill

    public CustomerEntity() {
    }

    public CustomerEntity(UUID id, String customerName, String password, String lastName, String email) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;


    }
}