package com.github.ukraine1449.getarmor;

import com.github.ukraine1449.getarmor.Commands.ArmorCommand;
import com.github.ukraine1449.getarmor.Events.MenuHandler;
import com.github.ukraine1449.getarmor.Events.PlayerHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GetArmor extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("getarmor").setExecutor(new ArmorCommand());
        getServer().getPluginManager().registerEvents(new PlayerHitEvent(), this);
        getServer().getPluginManager().registerEvents(new MenuHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
