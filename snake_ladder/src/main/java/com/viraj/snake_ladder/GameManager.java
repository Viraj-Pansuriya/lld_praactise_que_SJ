package com.viraj.snake_ladder;

import com.viraj.snake_ladder.model.Game;

public class GameManager {
    public static void main(String[] args) {

        Game game = new Game(10, 10,  2 , 6);
        game.startGame();
    }
}
