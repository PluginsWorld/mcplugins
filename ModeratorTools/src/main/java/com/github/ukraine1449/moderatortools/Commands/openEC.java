package com.github.ukraine1449.moderatortools.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class openEC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("modplugin.openED")) {


                if(args.length > 0 ){
                    Player target = Bukkit.getPlayerExact(args[0]);

                    Inventory ti = target.getEnderChest();
                    player.openInventory(ti);
                }else{
                    player.sendMessage("Please enter a valid target.");
                }



            }else{
                player.sendMessage("Please get the permission called modplugin.openED");
            }
        }

        return true;
    }
}
