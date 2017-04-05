package com.mbancer.gameoflife;

import com.mbancer.gameoflife.model.Generation;
import com.mbancer.gameoflife.presenter.ConsoleGenerationPresenter;
import com.mbancer.gameoflife.rules.RulesService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Generation generation = new Generation(200, 50);
        generation.makeCellAlive(55, 20);
        generation.makeCellAlive(54, 20);
        generation.makeCellAlive(55, 21);
        generation.makeCellAlive(55, 19);
        generation.makeCellAlive(56, 19);

        final ConsoleGenerationPresenter generationPresenter = new ConsoleGenerationPresenter();
        generationPresenter.presentGeneration(generation);

        final RulesService rulesService = new RulesService();

        for(int i = 0 ; i < 100 ; i++){
            final Generation newGeneration = rulesService.getNewGeneration(generation);
            generationPresenter.presentGeneration(newGeneration);
            Thread.sleep(500);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            generation = newGeneration;
        }
    }
}
