package com.example.atmdesign.model;

import com.example.atmdesign.model.states.AtmState;
import com.example.atmdesign.model.states.IdleState;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class AtmMachine {

    private AtmState currentState;
    private int currentAmount;
    private Card currentCard;
    private final Map<CurrencyType , Integer> inventory;

    public AtmMachine() {
        currentState = new IdleState();
        currentAmount = 64000;
        currentCard = null;
        inventory = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        this.inventory.put(CurrencyType.TWO_THOUSAND , 20);
        this.inventory.put(CurrencyType.FIVE_HUNDRED , 30);
        this.inventory.put(CurrencyType.HUNDRED , 40);
        this.inventory.put(CurrencyType.FIFTY , 50);
        this.inventory.put(CurrencyType.TWENTY , 60);
        this.inventory.put(CurrencyType.TEN, 130);
    }

    public void decreaseCurrentAmount(int amount) {
        currentAmount -= amount;
        // TODO : have to remove specific notes also.. (chain of responsibility principle);
    }



    public void insertCard(Card card) throws Exception {
        this.currentState.insertCard(this, card);
    }


    public void removeCard() throws Exception {
        this.currentState.removeCard(this);
    }


    public void withdrawMoney(int money) throws Exception {
        this.currentState.withdrawMoney(this, money);
    }


    public void authenticateCard(int pin) throws Exception {
        this.currentState.authenticateCard(this, pin);
    }


    public void checkBalance() throws Exception {
        this.currentState.checkBalance(this);
    }


    public void selectOperation(TransactionType transactionType) throws Exception {
        this.currentState.selectOperation(this, transactionType);
    }
}
