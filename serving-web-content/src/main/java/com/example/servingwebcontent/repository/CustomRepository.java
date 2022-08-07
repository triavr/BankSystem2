package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomRepository extends CrudRepository<CustomerEntity, UUID> {

      CustomerEntity findByCustomerName (String customerName);  // создаем метод возвращающий сущность клиента по имени
      @Query(value = "SELECT nextval(pg_get_serial_sequence('t_user', 'id'))", nativeQuery = true)
      UUID getNextId();
}
