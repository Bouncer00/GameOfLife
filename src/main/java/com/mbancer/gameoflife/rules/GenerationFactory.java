package com.mbancer.gameoflife.rules;

import com.mbancer.gameoflife.model.Generation;

public class GenerationFactory {

    final RulesService rulesService;

    public GenerationFactory(final RulesService rulesService){
        this.rulesService = rulesService;
    }
}
