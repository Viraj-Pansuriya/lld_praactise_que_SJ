package com.viraj.snake_ladder.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    @Getter int number;
    @Getter @Setter
    List<Player> players;

    public Cell(int number){
        this.number = number;
        this.players = new ArrayList<>();
    }
}