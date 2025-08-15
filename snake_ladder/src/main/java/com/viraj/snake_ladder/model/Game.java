package com.viraj.snake_ladder.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private int currentTurn;

    public Game(int boardSize , int playerSize , int diceSize) {
        this.currentTurn = 0;
        this.dice = new Dice(diceSize);
        this.board = new Board(boardSize);
        this.players = new ArrayList<>();
        for(int index = 0 ; index < playerSize ; index++) {
            players.add(new Player(index , board.getCells().getFirst()));
        }
        board.getCells().getFirst().getPlayers().addAll(players);
    }

    public void startGame(){
        long startTime = System.currentTimeMillis();
        while(true){
            int lastPosition = findLastPosition();
            if(isGameOver(lastPosition)) break;
            board.moveCurrentPlayerAndKillIfAny(lastPosition , players.get(currentTurn));
            incrementCounter();
        }
        long endTime = System.currentTimeMillis();

        // logging system steps:
        System.out.println("Winner of Game is : " +  players.get(currentTurn).getId());
        System.out.println("Time taken in millis : " + (endTime - startTime));

    }

    private boolean isGameOver(int lastPosition) {
        return lastPosition == board.getCells().size() - 1;
    }

    private void incrementCounter() {
        currentTurn++;
        currentTurn %= players.size();
    }

    private int findLastPosition() {
        int currentRoll = dice.roll();
        int currentPosition = players.get(currentTurn).getCurrentCell().getNumber();
        if(currentPosition + currentRoll >= board.getCells().size()) return currentPosition;
        return board.getLastPosition(currentPosition + currentRoll);
    }

}
