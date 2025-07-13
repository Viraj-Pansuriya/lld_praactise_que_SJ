package com.example.vendingmachine.model;

import java.util.List;

public class MoneyInsertionState implements VendingMachineState{
    @Override
    public void startAcceptingCoin(VendingMachineManager vendingMachineManager) throws Exception {
        //
        throw new Exception("already in money insertion state");
    }

    @Override
    public void addCoin(VendingMachineManager vendingMachineManager, Coin coin) throws Exception {
        vendingMachineManager.getCoinList().add(coin);
        System.out.println("Added coin " + coin);
    }

    @Override
    public List<Coin> cancelSelection(VendingMachineManager vendingMachineManager) throws Exception {
        List<Coin> coinList = vendingMachineManager.getCoinList();
        vendingMachineManager.getCoinList().clear();
        System.out.println("Proceeding for cancellation");
        vendingMachineManager.setCurrentState(new IdleState());
        return coinList;
    }

    @Override
    public void startProductSelection(VendingMachineManager vendingMachineManager, int code) throws Exception {
        vendingMachineManager.setCurrentCode(code);
        System.out.println("Proceeding for product selection");
        vendingMachineManager.setCurrentState(new ProductSelectionState());
    }

    @Override
    public void dispenseSelection(VendingMachineManager vendingMachineManager) throws Exception {
        throw new Exception("you have not selected item so far");
    }

    @Override
    public void changeSelectedItem(VendingMachineManager vendingMachineManager, int code) throws Exception {
        throw new Exception("you have not selected item so far");
    }
}
