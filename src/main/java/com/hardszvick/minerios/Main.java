package com.hardszvick.minerios;

import org.bukkit.plugin.java.JavaPlugin;

import com.hardszvick.minerios.application.OreRemovalService;
import com.hardszvick.minerios.domain.OreRemovalRule;
import com.hardszvick.minerios.infra.world.RemoveOrePopulator;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        String sWorld = getConfig().getString("remove_ores.world", "world");

        var world = getServer().getWorld(sWorld);

        if (world == null) {
            getLogger().warning("Mundo 'world' não existe. Plugin desativado.");
            return;
        }

        var rule = new OreRemovalRule();
        var service = new OreRemovalService(rule);

        world.getPopulators().add(new RemoveOrePopulator(service));
        getLogger().info("✅ SemMinérios ativo no mundo '"+ sWorld + "'.");
    }
}