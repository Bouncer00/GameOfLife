package com.mbancer.gameoflife.model;

import java.util.Objects;

public class Cell {
    private boolean alive;

    public Cell(final boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return alive == cell.alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alive);
    }

    
}
