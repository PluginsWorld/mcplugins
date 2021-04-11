package com.github.ukraine1449.moderatortools.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    public ArrayList<Player> listOfFlyingPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("modplugin.fly")){
                if(args.length > 0 ){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    String td = target.getDisplayName();
                    if(listOfFlyingPlayers.contains(target)){
                        target.setAllowFlight(false);
                        target.sendMessage(ChatColor.GOLD + "You cannot fly now");
                        listOfFlyingPlayers.remove(target);
                        player.sendMessage(ChatColor.GOLD + "You removed the ability to fly from " + ChatColor.AQUA + td);
                    } else if(!listOfFlyingPlayers.contains(target)) {
                        target.setAllowFlight(true);
                        listOfFlyingPlayers.add(target);
                        target.sendMessage(ChatColor.GOLD + "You can now fly");
                        player.sendMessage(ChatColor.GOLD + "You add the ability to fly to " + ChatColor.AQUA + td);
                    }
                }
                else {
                    if(listOfFlyingPlayers.contains(player)){
                        player.setAllowFlight(false);
                        listOfFlyingPlayers.remove(player);
                        player.sendMessage(ChatColor.GOLD + "You now cannot fly");
                    }
                    else {
                        player.setAllowFlight(true);
                        listOfFlyingPlayers.add(player);
                        player.sendMessage(ChatColor.GOLD + "You can now fly");
                    }
                }
            }else {
                player.sendMessage(ChatColor.GOLD + "Please get the permission called; modplugin.fly");
            }
        }else {
            System.out.println("Be a player to use this");
        }

        return true;
    }

}
