package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;
import com.example.atmdesign.model.factory.OperationFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationSelectionState implements AtmState {

    private final OperationFactory operationFactory = new OperationFactory();

    @Override
    public void insertCard(AtmMachine machine, Card card) throws Exception {
        throw new Exception("Operation selection state is not allowed");

    }

    @Override
    public void removeCard(AtmMachine machine) throws Exception {
        log.info("Card removed");
        machine.setCurrentCard(null);
        machine.setCurrentState(new IdleState());
    }

    @Override
    public void withdrawMoney(AtmMachine machine, int money) throws Exception {
        throw new Exception("not allowed");
    }

    @Override
    public void authenticateCard(AtmMachine machine, int pin) throws Exception {
        throw new Exception("not allowed");
    }

    @Override
    public void checkBalance(AtmMachine machine) throws Exception {
        throw new Exception("not allowed");
    }

    @Override
    public void selectOperation(AtmMachine machine, TransactionType transactionType) throws Exception {
        machine.setCurrentState(operationFactory.getAtmState(transactionType));
        log.info("Selected operation");
    }
}
