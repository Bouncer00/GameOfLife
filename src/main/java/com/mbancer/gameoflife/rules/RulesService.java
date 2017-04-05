package com.mbancer.gameoflife.rules;

import com.mbancer.gameoflife.model.Cell;
import com.mbancer.gameoflife.model.Generation;

import java.util.List;

public class RulesService {

    public Generation getNewGeneration(final Generation oldGeneration){
        final Generation newGeneration = new Generation(oldGeneration);
        applyRules(newGeneration, oldGeneration);
        return newGeneration;
    }

    private void applyRules(final Generation newGeneration, final Generation oldGeneration){
        for(int i = 0 ; i < oldGeneration.getSizeX(); i++){
            for(int j = 0 ; j < oldGeneration.getSizeY() ; j++){
                liveCellWithFewerThanTwoLiveNeighboursRule(newGeneration.getCellAt(i, j), oldGeneration.getCellAt(i, j), oldGeneration);
                liveCellWithTwoOrThreeLiveNeighboursRule(newGeneration.getCellAt(i, j), oldGeneration.getCellAt(i, j), oldGeneration);
                liveCellWithMoreThanThreeLiveNeighbours(newGeneration.getCellAt(i, j), oldGeneration.getCellAt(i, j), oldGeneration);
                deadCellWithExactlyThreeLiveNeighbours(newGeneration.getCellAt(i, j), oldGeneration.getCellAt(i, j), oldGeneration);
            }
        }
    }

    private void liveCellWithFewerThanTwoLiveNeighboursRule(final Cell newGenerationCell, final Cell oldGenerationCell, final Generation oldGeneration){
        if(oldGenerationCell.isAlive()) {
            final List<Cell> neighboursOfOldCell = oldGeneration.getNeighboursOfCell(oldGenerationCell.getXCoordinate(), oldGenerationCell.getYCoordinate());
            final long numberOfAliveNeighbours = neighboursOfOldCell.stream().filter(Cell::isAlive).count();
            if (numberOfAliveNeighbours < 2) {
                newGenerationCell.setAlive(false);
            }
        }
    }

    private void liveCellWithTwoOrThreeLiveNeighboursRule(final Cell newGenerationCell, final Cell oldGenerationCell, final Generation oldGeneration){
        if(oldGenerationCell.isAlive()) {
            final List<Cell> neighboursOfOldCell = oldGeneration.getNeighboursOfCell(oldGenerationCell.getXCoordinate(), oldGenerationCell.getYCoordinate());
            final long numberOfAliveNeighbours = neighboursOfOldCell.stream().filter(Cell::isAlive).count();
            if (numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3) {
                newGenerationCell.setAlive(true);
            }
        }
    }

    private void liveCellWithMoreThanThreeLiveNeighbours(final Cell newGenerationCell, final Cell oldGenerationCell, final Generation oldGeneration){
        if(oldGenerationCell.isAlive()){
            final List<Cell> neighboursOfOldCell = oldGeneration.getNeighboursOfCell(oldGenerationCell.getXCoordinate(), oldGenerationCell.getYCoordinate());
            final long numberOfAliveNeighbours = neighboursOfOldCell.stream().filter(Cell::isAlive).count();
            if (numberOfAliveNeighbours > 3) {
                newGenerationCell.setAlive(false);
            }
        }
    }

    private void deadCellWithExactlyThreeLiveNeighbours(final Cell newGenerationCell, final Cell oldGenerationCell, final Generation oldGeneration){
        if(!oldGenerationCell.isAlive()){
            final List<Cell> neighboursOfOldCell = oldGeneration.getNeighboursOfCell(oldGenerationCell.getXCoordinate(), oldGenerationCell.getYCoordinate());
            final long numberOfAliveNeighbours = neighboursOfOldCell.stream().filter(Cell::isAlive).count();
            if (numberOfAliveNeighbours == 3) {
                newGenerationCell.setAlive(true);
            }
        }
    }
}
