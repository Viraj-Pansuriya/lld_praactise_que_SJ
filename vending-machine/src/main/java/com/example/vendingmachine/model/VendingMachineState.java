package com.example.vendingmachine.model;

import java.util.List;

public interface VendingMachineState {
    void startAcceptingCoin(VendingMachineManager vendingMachineManager) throws Exception;
    void addCoin(VendingMachineManager vendingMachineManager , Coin coin) throws Exception;
    List<Coin> cancelSelection(VendingMachineManager vendingMachineManager) throws Exception;
    void startProductSelection(VendingMachineManager vendingMachineManager , int code) throws Exception;
    void dispenseSelection(VendingMachineManager vendingMachineManager) throws Exception;
    void changeSelectedItem(VendingMachineManager vendingMachineManager , int code) throws Exception;
}
