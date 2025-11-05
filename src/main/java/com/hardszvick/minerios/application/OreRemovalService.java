package com.hardszvick.minerios.application;

import org.bukkit.block.Block;

import com.hardszvick.minerios.domain.OreRemovalRule;

public class OreRemovalService {

    private final OreRemovalRule rule;

    public OreRemovalService(OreRemovalRule rule) {
        this.rule = rule;
    }

    public void process(Block block) {
        var replacement = rule.getReplacement(block.getType());
        if (replacement != null) {
            block.setType(replacement, false);
        }
    }
}
