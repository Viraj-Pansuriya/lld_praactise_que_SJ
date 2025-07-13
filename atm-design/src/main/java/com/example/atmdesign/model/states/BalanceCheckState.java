package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;
import com.example.atmdesign.model.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BalanceCheckState implements AtmState {
    @Override
    public void insertCard(AtmMachine machine, Card card) throws Exception {
        throw new Exception("Not allowed to insert card");
    }

    @Override
    public void removeCard(AtmMachine machine) throws Exception {
        machine.setCurrentCard(null);
        machine.setCurrentState(new IdleState());
        log.info("Card has been removed");
    }

    @Override
    public void withdrawMoney(AtmMachine machine, int money) throws Exception {
        throw new Exception("Not allowed to withdraw money");
    }

    @Override
    public void authenticateCard(AtmMachine machine, int pin) throws Exception {
        throw new Exception("Not allowed to authenticate card");
    }

    @Override
    public void checkBalance(AtmMachine machine) throws Exception {
        UserRepository userRepository = UserRepository.getInstance();
        int amount = userRepository.getAccount(machine.getCurrentCard().getCardNumber()).getBalance();
        log.info("Current balance is {}", amount);
    }

    @Override
    public void selectOperation(AtmMachine machine, TransactionType transactionType) throws Exception {
        throw new Exception("Not allowed to select operation");
    }
}
