package com.viraj.snake_ladder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
//    private String name;
    private int id;
    private Cell currentCell;

    public Player(int id , Cell currentCell) {
        this.id = id;
        this.currentCell = currentCell;
    }
}
