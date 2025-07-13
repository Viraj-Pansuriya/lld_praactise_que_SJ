package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;

public class IdleState implements AtmState {
    @Override
    public void insertCard(AtmMachine machine , Card card) {
        machine.setCurrentCard(card);
        machine.setCurrentState(new CardInsertionState());
    }

    @Override
    public void removeCard(AtmMachine machine) throws Exception {
        throw new Exception("not allowed to remove card");

    }

    @Override
    public void withdrawMoney(AtmMachine machine, int money) throws Exception {
        throw new Exception("not allowed to withdraw money");
    }

    @Override
    public void authenticateCard(AtmMachine machine, int pin) throws Exception {
        throw new Exception("not allowed to authenticate card");

    }

    @Override
    public void checkBalance(AtmMachine machine) throws Exception {
        throw new Exception("not allowed to check balance");
    }

    @Override
    public void selectOperation(AtmMachine machine, TransactionType transactionType) throws Exception {
        throw new Exception("not allowed to select operation");
    }
}
