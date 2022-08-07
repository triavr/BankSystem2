package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Entity.BillEntity;
import com.example.servingwebcontent.Entity.CustomerEntity;
import com.example.servingwebcontent.repository.BillRepository;
import com.example.servingwebcontent.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;                                           //инжектим сюда BillRepository

    @Autowired
    private CustomRepository customRepository;

    public BillEntity createBill(BillEntity bill, UUID customerId) {               //метод для создания Bill
        CustomerEntity customer = customRepository.findById(customerId).get();     //находим клиента по id, который получаем из параметров
        bill.setCustomer(customer);
//        return billRepository.save(bill);
//    }
//
//    public BillEntity renew(UUID id) {                                     //метод для обновления Bill
//        BillEntity bill = (BillEntity) billRepository.findById(id).get();
//        bill.setBillStatus(!bill.getBillBalance());
//        return billRepository.save(bill);
//    }

        return bill;
    }
}
