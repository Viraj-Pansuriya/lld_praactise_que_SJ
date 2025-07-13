package com.example.atmdesign.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    @Getter
    private final Map<String, Account> users = new HashMap<>();
    private static UserRepository instance;

    private UserRepository() {}

    public void addUser(String cardNumber, Account account) {
        users.put(cardNumber, account);
    }

    public Account getAccount(String cardNumber) {
        return users.get(cardNumber);
    }

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
