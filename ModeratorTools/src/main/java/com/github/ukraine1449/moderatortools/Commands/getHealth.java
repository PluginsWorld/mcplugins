package com.github.ukraine1449.moderatortools.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getHealth implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0 ){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("modplugin.getHealth")) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    double th = target.getHealth();
                    player.sendMessage(target + "'s health is at " + th);
                }
            }else{
                Player target = Bukkit.getPlayerExact(args[0]);
                double th = target.getHealth();
                System.out.println(target + "'s health is at " + th);

            }
        }else{
            if(sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage("Please enter the targets name");
            }else{
                System.out.println("Please enter the targets name");
            }
        }

        return true;
    }
}
