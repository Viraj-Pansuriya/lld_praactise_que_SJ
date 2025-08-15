package com.viraj.snake_ladder.model;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import java.util.*;

@Data
public class Board {
    private final Cell[][] cells;
    private final Map<Integer, Integer> jumps;

    public Board(int width, int height) {
        this.jumps = new HashMap<>();
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(x+y);
            }
        }
    }

    public void addJump(int startingCell, int endingCell) {
        if(jumps.containsKey(startingCell)) {
            throw new IllegalArgumentException("jump already exists");
        }
        jumps.put(startingCell, endingCell);
    }


    public int getLastPosition(int lastPosition) {
        while(jumps.containsKey(lastPosition)) lastPosition = jumps.get(lastPosition);
        return lastPosition;
    }

    public void moveCurrentPlayerAndKillIfAny(int lastPosition , Player player) {
        Cell cell = this.cells[getRowNumberBasedOnPosition(lastPosition)][getColumnNumberBasedOnPosition(lastPosition)];
        if(!CollectionUtils.isEmpty(cell.getPlayers())){
            cell.getPlayers().forEach(
                    ply-> player.setCurrentPosition(0)
            );
            cell.getPlayers().clear();
        }
        player.setCurrentPosition(lastPosition);
        cell.getPlayers().add(player);
    }

    public int getRowNumberBasedOnPosition(int position){
        return (position / cells[0].length);
    }

    public int getColumnNumberBasedOnPosition(int position){
        return (position % cells[0].length);
    }

    public int getTotalNumberOfCells() {
        return cells.length * cells[0].length;
    }
}