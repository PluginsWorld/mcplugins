package com.github.ukraine1449.rtpplugin;

import com.github.ukraine1449.rtpplugin.Commands.RTP;
import com.github.ukraine1449.rtpplugin.Commands.TelUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class RTPPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("RTP").setExecutor(new RTP());

        TelUtil utils = new TelUtil(this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
