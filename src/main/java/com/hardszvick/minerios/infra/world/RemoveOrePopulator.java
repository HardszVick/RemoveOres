package com.hardszvick.minerios.infra.world;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import com.hardszvick.minerios.application.OreRemovalService;

import java.util.Random;

public class RemoveOrePopulator extends BlockPopulator {

    private final OreRemovalService service;

    public RemoveOrePopulator(OreRemovalService service) {
        this.service = service;
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        if (!world.getName().equals("world")) return;

        int minY = world.getMinHeight();
        int maxY = world.getMaxHeight();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = minY; y < maxY; y++) {
                    service.process(chunk.getBlock(x, y, z));
                }
            }
        }
    }
}