package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Entity.CustomerEntity;
import com.example.servingwebcontent.exeptions.CustomerWasNotFound;
import com.example.servingwebcontent.exeptions.NameOccupiedExepshion;
import com.example.servingwebcontent.repository.CustomRepository;
import com.example.servingwebcontent.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class СustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping    //Создаем метод, который будет сохранять сущность в базу данных - метод для регистрации клиента
    public ResponseEntity registrationСustomer(@RequestBody CustomerEntity customer) {
        try {
            customerService.registration(customer);
            return ResponseEntity.ok("Вы успешно прошли регистрацию");
        } catch (NameOccupiedExepshion e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping()            //Создаем метод, который будет вовращать ResponseEntity , одного клиента
    public ResponseEntity getOneCustomers(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(customerService.getOneCustomer(id));
        } catch (CustomerWasNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")    //Создаем метод удаления клиента из базы
    public ResponseEntity deleteCustomer (@PathVariable UUID id) {  //Используем @PathVariable чтобы получить часть строки запроса id
        try {
            return ResponseEntity.ok(customerService.deleteOneCustomer(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
