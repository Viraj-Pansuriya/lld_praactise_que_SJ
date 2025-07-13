package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;

public interface AtmState {

    void insertCard(AtmMachine machine , Card card) throws Exception;
    void removeCard(AtmMachine machine) throws Exception;
    void withdrawMoney(AtmMachine machine , int money) throws Exception;
    // TODO : this can be implemented same way as withdraw cash;
//    void depositMoney(AtmMachine machine, int money);
    void authenticateCard(AtmMachine machine, int pin) throws Exception;
    void checkBalance(AtmMachine machine) throws Exception;
    void selectOperation(AtmMachine machine , TransactionType transactionType) throws Exception;
}
