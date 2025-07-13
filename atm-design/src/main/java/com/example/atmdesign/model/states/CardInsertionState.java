package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardInsertionState implements AtmState {
    @Override
    public void insertCard(AtmMachine machine, Card card) throws Exception {
        throw new Exception("card already inserted");
    }

    @Override
    public void removeCard(AtmMachine machine) throws Exception {
        machine.setCurrentCard(null);
        log.info("card removed");
        machine.setCurrentState(new IdleState());
    }

    @Override
    public void withdrawMoney(AtmMachine machine, int money) throws Exception {
        throw new Exception("not allowed");

    }

    @Override
    public void authenticateCard(AtmMachine machine, int pin) throws Exception {
        if(pin != machine.getCurrentCard().getPin()){
            log.error("pin not match");
            return ;
        }
        log.info("card authenticated");
        machine.setCurrentState(new OperationSelectionState());
    }

    @Override
    public void checkBalance(AtmMachine machine) throws Exception {
        throw new Exception("not allowed");

    }

    @Override
    public void selectOperation(AtmMachine machine, TransactionType transactionType) throws Exception {
        throw new Exception("not allowed");
    }
}
