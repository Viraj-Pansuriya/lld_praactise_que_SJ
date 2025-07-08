package com.example.tictactoe.model;

import lombok.Data;

@Data
public class PlayingPiece {

    private Sign sign;
    public PlayingPiece(Sign sign) {
        this.sign = sign;
    }
}
