package com.hardszvick.minerios.domain;

import org.bukkit.Material;

public class OreRemovalRule {

    public Material getReplacement(Material original) {
        switch (original) {
            case COAL_ORE:
            case IRON_ORE:
            case COPPER_ORE:
            case GOLD_ORE:
            case REDSTONE_ORE:
            case LAPIS_ORE:
            case DIAMOND_ORE:
            case EMERALD_ORE:
                return Material.STONE;
            case DEEPSLATE_COAL_ORE:
            case DEEPSLATE_IRON_ORE:
            case DEEPSLATE_COPPER_ORE:
            case DEEPSLATE_GOLD_ORE:
            case DEEPSLATE_REDSTONE_ORE:
            case DEEPSLATE_LAPIS_ORE:
            case DEEPSLATE_DIAMOND_ORE:
            case DEEPSLATE_EMERALD_ORE:
                return Material.DEEPSLATE;
            default:
                return null;
        }
    }
}