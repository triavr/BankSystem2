package com.example.servingwebcontent.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class BillEntity {
    @Id                            //помечаем спрингу, что является id (идентификатором)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private Long billNumber;
    private String billStatus;
    private Double billBalance;

    @Temporal(TemporalType.TIME)
    private Date createDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id") // указываем поле, по которому таблицы связаны
    private CustomerEntity customer;

    public BillEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Long billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public Double getBillBalance() {
        return billBalance;
    }

    public void setBillBalance(Double billBalance) {
        this.billBalance = billBalance;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
