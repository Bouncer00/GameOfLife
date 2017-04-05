package com.mbancer.gameoflife.model;

import com.mbancer.gameoflife.exception.GenerationCreationException;

import java.util.ArrayList;
import java.util.List;

public class Generation {
    private final static int DEFAULT_GENERATION_SIZE_X = 50;
    private final static int DEFAULT_GENERATION_SIZE_Y = 100;
    private final static int MINIMUM_SIZE = 20;
    private int sizeX;
    private int sizeY;
    private final Cell[][] cells;

    public Generation() {
        this(DEFAULT_GENERATION_SIZE_X, DEFAULT_GENERATION_SIZE_Y);
    }

    public Generation(final Generation generation){
        this.sizeX = generation.sizeX;
        this.sizeY = generation.sizeY;
        this.cells = new Cell[this.sizeX][this.sizeY];
        for(int i = 0 ; i < this.sizeX ; i++){
            for(int j = 0 ; j < this.sizeY; j++){
                this.cells[i][j] = new Cell(generation.cells[i][j]);
            }
        }
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
        for(int i = 0 ; i < this.sizeX; i++){
            for(int j = 0 ; j < this.sizeY; j++){
                this.cells[i][j] = new Cell(i, j , false);
            }
        }
    }

    public void makeCellAlive(final int x, final int y){
        cells[x][y].setAlive(true);
    }

    public void makeCellDead(final int x, final int y){
        cells[x][y].setAlive(false);
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
                neighboursList.add(cells[x+1][y-1]);
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

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
