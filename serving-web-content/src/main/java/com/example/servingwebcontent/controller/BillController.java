package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Entity.BillEntity;
import com.example.servingwebcontent.Entity.CustomerEntity;
import com.example.servingwebcontent.exeptions.NameOccupiedExepshion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("bills")
public class BillController {

    @PostMapping    //Создаем метод, который будет сохранять сущность в базу данных - метод для создания счета
    public ResponseEntity createbill(@RequestBody BillEntity bill,
                                     @RequestParam UUID customerId) {
//        try {
//
//        } catch (NameOccupiedExepshion e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");

        }



//    @PutMapping    //Создаем метод, который будет обновлять сущность в базе - метод для обновления счета
//    public ResponseEntity renewbill(@RequestParam UUID id) {
//        try {
//
//        } catch (NameOccupiedExepshion e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//
//        }
//    }
}
