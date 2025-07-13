package com.example.vendingmachine;

import com.example.vendingmachine.model.Coin;
import com.example.vendingmachine.model.VendingMachineManager;
import com.example.vendingmachine.model.VendingMachineState;

public class MainApplication {

    public static void main(String[] args) throws Exception{
        VendingMachineManager vendingMachineManager = new VendingMachineManager();

        vendingMachineManager.startAcceptingCoin();
        vendingMachineManager.addCoin(Coin.FIVE_RUPEE);
        vendingMachineManager.addCoin(Coin.FIVE_RUPEE);
//        vendingMachineManager.cancelSelection();

        vendingMachineManager.startProductSelection(101);
        vendingMachineManager.dispenseSelection();
        vendingMachineManager.displayInventory();
    }



}
