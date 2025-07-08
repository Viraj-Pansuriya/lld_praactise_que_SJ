package com.example.tictactoe;

import com.example.tictactoe.model.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(4 , 2);

        // NOTE : design is such a way that in case of player > signs , it will combine additional players in a RR fashion.
//        Game game = new Game(5,3);
        game.startGame();
    }

}
