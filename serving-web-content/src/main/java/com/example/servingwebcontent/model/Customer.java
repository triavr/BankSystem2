package com.example.servingwebcontent.model;

import com.example.servingwebcontent.Entity.CustomerEntity;

import java.rmi.server.UID;
import java.util.UUID;

public class Customer {   //создаем модель для обмена данных между сервисом и клиентом
    private UUID id;        //указываем только те поля, которые будут использоваться на клиенте

    private String customerName;

    public Customer() {
    }

    public static Customer toModel(CustomerEntity entity) {   //создаем статичный метод ковертер (параметром принимаем сущность, а возвращаем модель)
        Customer model = new Customer();
        model.setId(entity.getId());
        model.setCustomerName(entity.getCustomerName());
        return model;
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
}
