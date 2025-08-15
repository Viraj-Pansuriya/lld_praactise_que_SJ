package com.viraj.snake_ladder.model;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import java.util.*;

@Data
public class Board {
    private final Cell[][] cells;
    private final Map<Integer, Integer> jumps;
    // instead of this , we can also have a jump object for each cell.

    public Board(int width, int height) {
        this.jumps = new HashMap<>();
        cells = new Cell[width][height];

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                cells[x][y] = new Cell(x * width + y);
            }
        }
        initializeBoard();
    }

    public void initializeBoard(){
        this.addJump(2 , 10);
        this.addJump(3 , 10);
        this.addJump(4 , 10);
        this.addJump(20 , 6);
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