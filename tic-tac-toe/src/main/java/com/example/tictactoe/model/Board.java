package com.example.tictactoe.model;

import lombok.Data;

@Data
public class Board {

    private final Cell[][] cells;

    public Board(int n) {
        cells = new Cell[n][n];
    }

    public boolean doOperation(int row , int col , Sign sign) {
        if(cells[row][col] == null){
            cells[row][col] = new Cell(sign);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if(cell == null){
                    sb.append("**");
                }
                else sb.append(cell.sign.name());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
