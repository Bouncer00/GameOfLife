package com.mbancer.gameoflife;

import com.mbancer.gameoflife.model.Generation;
import com.mbancer.gameoflife.rules.RulesService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RulesServiceTest {

    private RulesService rulesService;

    @Before
    public void setUp(){
        this.rulesService = new RulesService();
    }

    @Test
    public void shouldKillAliveCellWithFewerThanTwoNeighboursAlive(){
        //given
        final int cellX = 2;
        final int cellY = 4;
        final Generation generation = new Generation();
        generation.makeCellAlive(cellX, cellY);

        //when
        final Generation newGeneration = rulesService.getNewGeneration(generation);

        //then
        assertFalse(newGeneration.getCellAt(cellX, cellY).isAlive());
    }

    @Test
    public void shouldKeepAliveAliveCellWithTwoNeighboursAlive(){
        //given
        final int cellX = 2;
        final int cellY = 4;
        
        final Generation generation = new Generation();
        generation.makeCellAlive(cellX, cellY);
        generation.makeCellAlive(cellX+1, cellY);
        generation.makeCellAlive(cellX-1, cellY);

        //when
        final Generation newGeneration = rulesService.getNewGeneration(generation);

        //then
        assertTrue(newGeneration.getCellAt(cellX, cellY).isAlive());
    }

    @Test
    public void shouldKeepAliveAliveCellWithThreeNeighboursAlive(){
        //given
        final int cellX = 2;
        final int cellY = 4;
        
        final Generation generation = new Generation();
        generation.makeCellAlive(cellX, cellY);
        generation.makeCellAlive(cellX+1, cellY);
        generation.makeCellAlive(cellX-1, cellY);
        generation.makeCellAlive(cellX, cellY - 1);

        //when
        final Generation newGeneration = rulesService.getNewGeneration(generation);

        //then
        assertTrue(newGeneration.getCellAt(cellX, cellY).isAlive());
    }

    @Test
    public void shouldKillAliveCellWithMoreThanThreeNeighboursAlive(){
        //given
        final int cellX = 2;
        final int cellY = 4;
        
        final Generation generation = new Generation();
        generation.makeCellAlive(cellX, cellY);
        generation.makeCellAlive(cellX + 1, cellY);
        generation.makeCellAlive(cellX - 1, cellY);
        generation.makeCellAlive(cellX, cellY - 1);
        generation.makeCellAlive(cellX, cellY + 1);

        //when
        final Generation newGeneration = rulesService.getNewGeneration(generation);

        //then
        assertFalse(newGeneration.getCellAt(cellX, cellY).isAlive());
    }

    @Test
    public void shouldReviveDeadCellWithThreeLiveNeighbours(){
        //given
        final int cellX = 2;
        final int cellY = 4;
        
        final Generation generation = new Generation();
        generation.makeCellDead(cellX, cellY);
        generation.makeCellAlive(cellX + 1, cellY);
        generation.makeCellAlive(cellX - 1, cellY);
        generation.makeCellAlive(cellX, cellY - 1);

        //when
        final Generation newGeneration = rulesService.getNewGeneration(generation);

        //then
        assertTrue(newGeneration.getCellAt(cellX, cellY).isAlive());
    }
}
