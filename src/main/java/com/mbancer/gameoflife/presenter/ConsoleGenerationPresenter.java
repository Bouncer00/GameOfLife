package com.mbancer.gameoflife.presenter;

import com.mbancer.gameoflife.model.Cell;
import com.mbancer.gameoflife.model.Generation;

public class ConsoleGenerationPresenter{
    public void presentGeneration(final Generation generation){
        for(int i = 0 ; i < generation.getSizeY() ; i++){
            for(int j = 0 ; j < generation.getSizeX() ; j++){
                System.out.print(getCellSymbol(generation.getCellAt(j, i)));
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getCellSymbol(final Cell cell){
        return cell.isAlive() ? "X" : " ";
    }
}
