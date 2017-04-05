package com.mbancer.gameoflife;

import com.mbancer.gameoflife.model.Cell;
import com.mbancer.gameoflife.model.Generation;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GenerationTest {

    private Generation generation;

    @Before
    public void setUp(){
        generation = new Generation();
    }

    @Test
    public void shouldSetCellAtCoordinates(){
        //given
        final int x = 2;
        final int y = 4;
        final boolean alive = true;

        //when
        generation.makeCellAlive(x, y);

        //then
        final Cell returnedCell = generation.getCellAt(x, y);
        assertNotNull(returnedCell);
        assertEquals(x ,returnedCell.getXCoordinate());
        assertEquals(y ,returnedCell.getYCoordinate());
        assertEquals(alive ,returnedCell.isAlive());
    }

    @Test
    public void shouldGetNeighboursOfCell(){
        //given
        final int cellX = 1;
        final int cellY = 3;

        generation.makeCellAlive(cellX,cellY);
        generation.makeCellAlive(cellX + 1,cellY);
        generation.makeCellAlive(cellX + 1,cellY + 1);
        final List<Cell> neighbours = Arrays.asList(generation.getCellAt(cellX + 1, cellY), generation.getCellAt(cellX + 1, cellY + 1));

        //when
        final List<Cell> cellList = generation.getNeighboursOfCell(cellX, cellY);

        //then
        assertTrue(cellList.containsAll(neighbours));
    }
}
