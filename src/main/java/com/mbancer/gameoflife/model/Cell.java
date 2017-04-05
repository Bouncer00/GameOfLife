package com.mbancer.gameoflife.model;

import java.util.Objects;

public class Cell {
    private boolean alive;
    private int XCoordinate;
    private int YCoordinate;

    Cell(final Cell oldCell){
        this.alive = oldCell.alive;
        this.XCoordinate = oldCell.XCoordinate;
        this.YCoordinate = oldCell.YCoordinate;
    }

    Cell(final int x, final int y, final boolean alive){
        this.XCoordinate = x;
        this.YCoordinate = y;
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getXCoordinate() {
        return XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return alive == cell.alive &&
                XCoordinate == cell.XCoordinate &&
                YCoordinate == cell.YCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alive, XCoordinate, YCoordinate);
    }
}
