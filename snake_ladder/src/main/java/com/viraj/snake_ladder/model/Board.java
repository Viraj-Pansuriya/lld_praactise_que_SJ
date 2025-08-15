package com.viraj.snake_ladder.model;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import java.util.*;

@Data
public class Board {
    private final List<Cell> cells;
    private final Map<Integer, Integer> jumps; // for lookup only;

    public Board(int size) {
        this.jumps = new HashMap<>();
        cells = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cells.add(new Cell(i));
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
        Cell cell = this.cells.get(lastPosition);
        if(!CollectionUtils.isEmpty(cell.getPlayers())){
            cell.getPlayers().forEach(
                    ply-> player.setCurrentPosition(0)
            );
            cell.getPlayers().clear();
        }
        player.setCurrentPosition(lastPosition);
        cell.getPlayers().add(player);
    }
}