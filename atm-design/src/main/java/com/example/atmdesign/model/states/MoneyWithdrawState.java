package com.example.atmdesign.model.states;

import com.example.atmdesign.model.AtmMachine;
import com.example.atmdesign.model.Card;
import com.example.atmdesign.model.TransactionType;
import com.example.atmdesign.model.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MoneyWithdrawState implements AtmState {
    @Override
    public void insertCard(AtmMachine machine, Card card) throws Exception {
        throw  new Exception("not allowed");
    }

    @Override
    public void removeCard(AtmMachine machine) throws Exception {
        machine.setCurrentCard(null);
        machine.setCurrentState(new IdleState());
    }

    @Override
    public void withdrawMoney(AtmMachine machine, int money) throws Exception {

        if(machine.getCurrentAmount() < money){
            log.error("money exceeds limit for ATM machine");
            return ;
        }
        int balance = UserRepository.getInstance().getAccount(machine.getCurrentCard().getCardNumber()).getBalance();
        if(balance < money){
            log.error("balance less than money");
            return ;
        }
        UserRepository.getInstance().getAccount(machine.getCurrentCard().getCardNumber()).setBalance(balance - money);
        machine.decreaseCurrentAmount(money);
        log.info("money has been withdrawn");
    }

    @Override
    public void authenticateCard(AtmMachine machine, int pin) throws Exception {
        throw  new Exception("not allowed");
    }

    @Override
    public void checkBalance(AtmMachine machine) throws Exception {
        throw  new Exception("not allowed");
    }

    @Override
    public void selectOperation(AtmMachine machine, TransactionType transactionType) throws Exception {
        throw  new Exception("not allowed");
    }
}
