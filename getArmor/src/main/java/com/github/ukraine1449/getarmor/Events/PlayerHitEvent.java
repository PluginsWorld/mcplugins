package com.github.ukraine1449.getarmor.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerHitEvent implements Listener {

    @EventHandler
    void playerHitEvent(EntityDamageByEntityEvent event){
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();

        if(damager.getType() == EntityType.PLAYER){
            if(damaged.getType() == EntityType.PLAYER){
                Bukkit.broadcastMessage("Code 1556");
                Player target = (Player) damaged;
                String dn = target.getDisplayName();
                double health = target.getHealth();
                damager.sendMessage(ChatColor.AQUA + dn + ChatColor.GOLD + " has " + ChatColor.RED + health + ChatColor.GOLD + " health");
            }

        }
    }

}
