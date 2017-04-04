package com.mbancer.gameoflife.model;

import com.mbancer.gameoflife.exception.GenerationCreationException;

import java.util.ArrayList;
import java.util.List;

public class Generation {
    private final static int DEFAULT_GENERATION_SIZE_X = 50;
    private final static int DEFAULT_GENERATION_SIZE_Y = 50;
    private final static int MINIMUM_SIZE = 20;
    private int sizeX;
    private int sizeY;

    private final Cell[][] cells;

    public Generation() throws GenerationCreationException {
        this(DEFAULT_GENERATION_SIZE_X, DEFAULT_GENERATION_SIZE_Y);
    }

    public Generation(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        if(this.sizeX < MINIMUM_SIZE){
            throw new GenerationCreationException(String.format("Size X = %d of generation is too small, minimum is %d", sizeX, MINIMUM_SIZE));
        }
        if(this.sizeY < MINIMUM_SIZE){
            throw new GenerationCreationException(String.format("Size Y = %d of generation is too small, minimum is %d", sizeY, MINIMUM_SIZE));
        }
        this.cells = new Cell[this.sizeX][this.sizeY];
    }

    public void setCellAt(final Cell cell, int x, int y){
        cells[x][y] = cell;
    }

    public Cell getCellAt(final int x, final int y){
        return cells[x][y];
    }

    public List<Cell> getNeighboursOfCell(final int x, final int y){
        final List<Cell> neighboursList = new ArrayList<>();
        if(x > 0){
            neighboursList.add(cells[x-1][y]);
            if(y > 0){
                neighboursList.add(cells[x-1][y-1]);
            }
            if(y < this.sizeY - 1){
                neighboursList.add(cells[x-1][y+1]);
            }
        }
        if(x < this.sizeX - 1){
            neighboursList.add(cells[x+1][y]);
            if(y > 0){
                neighboursList.add(cells[x+11][y-1]);
            }
            if(y < this.sizeY - 1){
                neighboursList.add(cells[x+1][y+1]);
            }
        }
        if(y > 0){
            neighboursList.add(cells[x][y-1]);
        }
        if(y < this.sizeY - 1){
            neighboursList.add(cells[x][y+1]);
        }
        return neighboursList;
    }
}
