package com.viraj.snake_ladder.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
//    private String name;
    private int id;
    private int currentPosition;

    public Player(int id , int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }
}
