package com.github.ukraine1449.moderatortools.Commands;

import com.github.ukraine1449.moderatortools.ModeratorTools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
ModeratorTools plugin;

    public PlayerJoinEvent(ModeratorTools plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.hasPlayedBefore() == false){
            Bukkit.broadcastMessage(player.getDisplayName() + " has joined for the first time. Welcome!");
        }else{
            Bukkit.broadcastMessage(player.getDisplayName() + " has joined. Welcome back");
        }
        for(int i = 0; i < plugin.vanished.size(); i++){
            player.hidePlayer(plugin, plugin.vanished.get(i));
            player.hidePlayer(player);
        }
    }

}
