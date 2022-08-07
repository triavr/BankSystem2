package com.example.servingwebcontent.exeptions;

public class NameOccupiedExepshion extends Exception {        // исключение - Имя пользователя уже занято

    public NameOccupiedExepshion(String message) {

        super(message);
    }
}
