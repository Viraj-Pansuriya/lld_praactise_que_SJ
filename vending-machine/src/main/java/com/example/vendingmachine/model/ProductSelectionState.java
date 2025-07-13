package com.example.vendingmachine.model;

import java.util.Arrays;
import java.util.List;

public class ProductSelectionState implements VendingMachineState {
    @Override
    public void startAcceptingCoin(VendingMachineManager vendingMachineManager) throws Exception {
        throw new Exception("not allowed to start accepting coin");
    }

    @Override
    public void addCoin(VendingMachineManager vendingMachineManager, Coin coin) throws Exception {
        throw new Exception("not allowed to add coin");
    }

    @Override
    public List<Coin> cancelSelection(VendingMachineManager vendingMachineManager) throws Exception {
        List<Coin> response = vendingMachineManager.getCoinList();
        vendingMachineManager.getCoinList().clear();
        System.out.println("cancelling selection");
        vendingMachineManager.setCurrentCode(null);
        vendingMachineManager.setCurrentState(new IdleState());
        return response;
    }

    @Override
    public void startProductSelection(VendingMachineManager vendingMachineManager, int code) throws Exception {
        throw new Exception("Already in product selection");
    }

    @Override
    public void dispenseSelection(VendingMachineManager vendingMachineManager) throws Exception {
        int currentMoney = vendingMachineManager.getCoinList().stream()
                .map(Coin::getValue).reduce(0, Integer::sum);

        int originalMoney = Arrays.stream(vendingMachineManager.getInventory())
                .filter(k-> k.getCode() == vendingMachineManager.getCurrentCode())
                .findFirst()
                .map(k-> k.getItem().getPrice())
                .orElseThrow(() -> new Exception("Not able to find current code"));

        if(currentMoney < originalMoney){
            refund(vendingMachineManager, currentMoney);
            vendingMachineManager.setCurrentState(new IdleState());
            throw  new Exception("Not enough money");
        }


        if (currentMoney > originalMoney) {
            refund(vendingMachineManager, currentMoney - originalMoney);
        }

        dispenseProduct(vendingMachineManager);
        vendingMachineManager.setCurrentState(new IdleState());
    }

    private void dispenseProduct(VendingMachineManager vendingMachineManager) {
        System.out.println("dispensing current selected item : " + vendingMachineManager.getCurrentCode());
        Arrays.stream(vendingMachineManager.getInventory())
                .filter(k -> k.getCode() == vendingMachineManager.getCurrentCode())
                .findFirst().
                ifPresent(
                        k -> k.getItem().reduceQuantity()
                );
        vendingMachineManager.setCurrentCode(null);
    }

    @Override
    public void changeSelectedItem(VendingMachineManager vendingMachineManager, int code) throws Exception {
        vendingMachineManager.setCurrentCode(code);
        System.out.println("Changed selected item");
    }

    public void refund(VendingMachineManager vendingMachineManager , int price) throws Exception {
        System.out.println("refund of amount " + price);
        vendingMachineManager.getCoinList().clear();
    }
}
