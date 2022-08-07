package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Entity.CustomerEntity;
import com.example.servingwebcontent.exeptions.CustomerWasNotFound;
import com.example.servingwebcontent.exeptions.NameOccupiedExepshion;
import com.example.servingwebcontent.model.Customer;
import com.example.servingwebcontent.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    // указываем спрингу, чтобы он внедрил обьект этого класса
    private CustomRepository customRepository;


    public CustomerEntity registration(CustomerEntity customer) throws NameOccupiedExepshion {             // реализуем метод для регистрации клиентов
        if (customRepository.findByCustomerName(customer.getCustomerName()) != null) {                     //перед сохранением пользователя делаем запрос на получение клиента с именем, которое пришло в теле запроса

            throw new NameOccupiedExepshion("Аккаунт с таким именем уже существует");                      //пробрасываем ошибку
        }
        return customRepository.save(customer);
    }

    public Customer getOneCustomer(UUID id) throws CustomerWasNotFound {   // реализуем метод получения id и имени одного клиента (без пароля и других полей за счет модели)
        CustomerEntity customer = customRepository.findById(id).get();
        if ( customer == null) {     // делаем проверку пробуем найти клиента по id}
        throw new CustomerWasNotFound("Клиент не был найден");
        }
        return Customer.toModel(customer);
    }

    public UUID deleteOneCustomer(UUID id) {      //реализуем метод удаления одного клиента из базы
        customRepository.deleteById(id);
        return id;
    }
}