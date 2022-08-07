package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.Entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomRepository extends CrudRepository<CustomerEntity, UUID> {

      CustomerEntity findByCustomerName (String customerName);  // создаем метод возвращающий сущность клиента по имени
}
