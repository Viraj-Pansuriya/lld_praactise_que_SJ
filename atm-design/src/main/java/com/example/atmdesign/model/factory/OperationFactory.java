package com.example.atmdesign.model.factory;

import com.example.atmdesign.model.TransactionType;
import com.example.atmdesign.model.states.AtmState;
import com.example.atmdesign.model.states.BalanceCheckState;
import com.example.atmdesign.model.states.MoneyWithdrawState;

public class OperationFactory {

    public AtmState getAtmState(TransactionType transactionType) {
        return switch (transactionType) {
            case CHECK_BALANCE -> new BalanceCheckState();
            case MONEY_WITHDRAWAL -> new MoneyWithdrawState();
        };
    }
}
