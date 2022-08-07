package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Entity.CustomerEntity;
import com.example.servingwebcontent.Entity.Role;
import com.example.servingwebcontent.exeptions.CustomerWasNotFound;
import com.example.servingwebcontent.exeptions.NameOccupiedExepshion;
import com.example.servingwebcontent.model.Customer;
import com.example.servingwebcontent.repository.CustomRepository;
import com.example.servingwebcontent.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    // указываем спрингу, чтобы он внедрил обьект этого класса
    private CustomRepository customRepository;

    @Autowired
    RoleRepository roleRepository;

    public Iterable<CustomerEntity> allUsers() {
        return customRepository.findAll();
    }

    public boolean saveCustomer(Customer customer) {
        Customer userFromDB = customRepository.findByCustomerName(customer.getCustomerName());

        if (userFromDB != null) {
            return false;
        }

        customer.setRoles(Collections.singleton(new Role(1L, "ROLE_CUSTOMER"))); //добавляем роль CUSTOMER
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customRepository.save(customer);
        return true;
    }

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