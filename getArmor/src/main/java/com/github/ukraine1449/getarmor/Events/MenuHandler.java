package com.github.ukraine1449.getarmor.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuHandler implements Listener {
String name = "getArmor menu";
    @EventHandler
    public void onMenuClick(InventoryClickEvent event){
        if(event.getView().getTitle().equalsIgnoreCase(name)){
            event.setCancelled(true);
        }
    }

}
