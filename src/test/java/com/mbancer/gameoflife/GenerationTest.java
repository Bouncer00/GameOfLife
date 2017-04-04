package com.mbancer.gameoflife;

import com.mbancer.gameoflife.model.Cell;
import com.mbancer.gameoflife.model.Generation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GenerationTest {

    @Test
    public void shouldSetCellAtCoordinates(){
        //given
        final Generation generation = new Generation();
        final Cell cell = new Cell();
        final int x = 2;
        final int y = 4;

        //when
        generation.setCellAt(cell, x, y);

        //then
        final Cell returnedCell = generation.getCellAt(x, y);
        assertNotNull(returnedCell);
        assertEquals(cell,returnedCell);
    }

    @Test
    public void shouldGetNeighboursOfCell(){
        //given
        final Generation generation = new Generation();


        //when

        //then
    }
}
