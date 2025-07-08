package com.example.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    String name;
    Sign sign;
}
