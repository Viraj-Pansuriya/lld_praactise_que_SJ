package com.viraj.snake_ladder;

import com.viraj.snake_ladder.model.Game;

public class GameManager {
    public static void main(String[] args) {

        Game game = new Game(100,  2 , 6);
        addJumpsForAGame(game);
        game.startGame();
    }

    private static void addJumpsForAGame(Game game) {
        game.getBoard().addJump(2 , 10);
        game.getBoard().addJump(3 , 10);
        game.getBoard().addJump(4 , 10);
        game.getBoard().addJump(20 , 6);
    }
}
