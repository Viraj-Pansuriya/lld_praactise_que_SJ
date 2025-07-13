package com.example.atmdesign;

import com.example.atmdesign.model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        Card card = Card.builder()
                .cardNumber("abc123")
                .pin(2369)
                .bankName("Kotak Mahindra Bank")
                .expiryDate(LocalDateTime.of(2030 , 12 , 12 , 0 , 0))
                .holderName("Viraj Pansuriya")
                .build();

        Account account = new Account();
        account.setId(123);
        account.setBalance(50000);
        account.setCard(card);


        UserRepository.getInstance().addUser(card.getCardNumber(), account);

        AtmMachine atmMachine = new AtmMachine();
        atmMachine.insertCard(card);
        atmMachine.authenticateCard(2369);
        atmMachine.selectOperation(TransactionType.CHECK_BALANCE);
        atmMachine.checkBalance();
        atmMachine.removeCard();

        atmMachine.insertCard(card);
        atmMachine.authenticateCard(2369);
        atmMachine.selectOperation(TransactionType.MONEY_WITHDRAWAL);
        atmMachine.withdrawMoney(6000);
        atmMachine.removeCard();

        atmMachine.insertCard(card);
        atmMachine.authenticateCard(2369);
        atmMachine.selectOperation(TransactionType.CHECK_BALANCE);
        atmMachine.checkBalance();
        atmMachine.removeCard();

    }
}
