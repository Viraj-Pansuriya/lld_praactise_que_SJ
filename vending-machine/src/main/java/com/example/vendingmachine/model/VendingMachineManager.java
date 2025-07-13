package com.example.vendingmachine.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VendingMachineManager  {
    @Getter
    private final ItemShelf[] inventory;
    @Getter
    private final List<Coin> coinList;
    @Getter
    @Setter
    private VendingMachineState currentState;

    @Getter
    @Setter
    private Integer currentCode;

    public VendingMachineManager(){
        this.inventory = new ItemShelf[10];
        this.coinList = new ArrayList<>();
        this.currentState = new IdleState();
        this.currentCode = null;
        fillInventory();
    }

    private void fillInventory() {
        int prefix = 100;

        for(int index = 0 ; index < 3 ; index++) {
            Item item = new Item(5 , 5 , ItemType.PEPSI);
            this.inventory[index] = new ItemShelf(item , prefix + index);
        }
        for(int index = 3 ; index < 5 ; index++){
            Item item = new Item(10 , 5 , ItemType.JUICE);
            this.inventory[index] = new ItemShelf(item , prefix + index);
        }
        for(int index = 5 ; index < 8 ; index++){
            Item item = new Item(15 , 5 , ItemType.SODA);
            this.inventory[index] = new ItemShelf(item , prefix + index);
        }
        for(int index= 8 ; index < 10 ; index++){
            Item item = new Item(20 , 5 , ItemType.MILK_SHAKE);
            this.inventory[index] = new ItemShelf(item , prefix + index);
        }
    }

    public void displayInventory() {

        System.out.println("#### INVENTORY START ###");
        for(ItemShelf itemShelf : this.inventory) {
            System.out.println(itemShelf);
        }

        System.out.println("#### INVENTORY END  ###");
    }



    public void startAcceptingCoin() throws Exception {
        this.currentState.startAcceptingCoin( this);
    }


    public void addCoin(Coin coin) throws Exception {
            this.currentState.addCoin( this, coin);
    }


    public List<Coin> cancelSelection() throws Exception {
        return this.currentState.cancelSelection( this);
    }


    public void startProductSelection(int code) throws Exception {
         this.currentState.startProductSelection( this, code);
    }


    public void dispenseSelection() throws Exception {
        this.currentState.dispenseSelection( this);
    }


    public void changeSelectedItem(int code) throws Exception {
        this.currentState.changeSelectedItem( this, code);
    }
}
