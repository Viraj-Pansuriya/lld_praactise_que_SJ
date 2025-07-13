package com.example.vendingmachine.model;

import java.util.List;

public class IdleState implements VendingMachineState {
    @Override
    public void startAcceptingCoin(VendingMachineManager vendingMachineManager) {
        System.out.println("Starting accepting coin");
        vendingMachineManager.setCurrentState(new MoneyInsertionState());

    }

    @Override
    public void addCoin(VendingMachineManager vendingMachineManager, Coin coin) throws Exception {
        throw new Exception("first start accepting coin");
    }

    @Override
    public List<Coin> cancelSelection(VendingMachineManager vendingMachineManager) throws Exception {
        throw new Exception("cancel is not allowed in idle state");

    }

    @Override
    public void startProductSelection(VendingMachineManager vendingMachineManager, int code) throws Exception {
        throw new Exception("product selection is not allowed in idle state");
    }

    @Override
    public void dispenseSelection(VendingMachineManager vendingMachineManager) throws Exception {
        throw new Exception("dispense is not allowed in idle state");
    }

    @Override
    public void changeSelectedItem(VendingMachineManager vendingMachineManager, int code) throws Exception {
        throw new Exception("change is not allowed in idle state");
    }
}
