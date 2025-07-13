package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;

public class AuthenticationState implements AtmState {
    @Override
    public void insertCard(AtmMachine machine, Card card) throws Exception {

    }

    @Override
    public void removeCard(AtmMachine machine) throws Exception {

    }

    @Override
    public void withdrawMoney(AtmMachine machine, int money) throws Exception {

    }

    @Override
    public void authenticateCard(AtmMachine machine, int pin) throws Exception {

    }

    @Override
    public void checkBalance(AtmMachine machine) throws Exception {

    }

    @Override
    public void selectOperation(AtmMachine machine, TransactionType transactionType) throws Exception {

    }
}
