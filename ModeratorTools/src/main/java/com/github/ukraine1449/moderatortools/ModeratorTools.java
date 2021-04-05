package com.github.ukraine1449.moderatortools;

import com.github.ukraine1449.moderatortools.Commands.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ModeratorTools extends JavaPlugin {
    public ArrayList<Player> vanished = new ArrayList<>();
    @Override
    public void onEnable() {
        getCommand("getfood").setExecutor(new getFood());
        getCommand("getHealth").setExecutor(new getHealth());
        getCommand("god").setExecutor(new God());
        getCommand("vanish").setExecutor(new Vanish(this));
        getCommand("openinv").setExecutor(new OpenInv());
        getCommand("openec").setExecutor(new openEC());
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
