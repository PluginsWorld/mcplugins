package com.github.ukraine1449.armorstandgui.Commands;

import com.github.ukraine1449.armorstandgui.ArmorStandGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class asgui implements CommandExecutor {
ArmorStandGUI plugin;

    public asgui(ArmorStandGUI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("asgui.create")){
                plugin.openMainMenu(player);
            }
        }


        return true;
    }



}
