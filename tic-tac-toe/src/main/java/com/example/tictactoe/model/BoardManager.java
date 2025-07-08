package com.example.tictactoe.model;

import lombok.Getter;


public class BoardManager {

    @Getter
    private final Board board;
    public BoardManager(int n) {
        board = new Board(n);
    }

    public boolean makeMove(int row, int col , Sign sign) {
        return board.doOperation(row, col, sign);
    }


}
