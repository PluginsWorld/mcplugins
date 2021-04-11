package com.github.ukraine1449.getarmor.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Locale;
import java.util.Map;

public class ArmorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("getarmor.getarmor")){

                Player target = Bukkit.getPlayerExact(args[0]);
                String td = target.getDisplayName();
                EntityEquipment equipment = target.getEquipment();
                ItemStack Chestplate = equipment.getChestplate();
                ItemStack Helmet = equipment.getHelmet();
                ItemStack leggings = equipment.getLeggings();
                ItemStack boots =  equipment.getBoots();
                Inventory armor = Bukkit.createInventory(player, 9, "getArmor menu");






                if (Helmet != null) {
                    String hn = Helmet.getType().name().toLowerCase();
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is wearing " + ChatColor.AQUA + hn);
                    ItemStack hi = new ItemStack(Helmet);
                    armor.addItem(hi);
                }else{
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + "  not wearing a helmet");
                }
                if (Chestplate != null) {
                    String cn = Chestplate.getType().name().toLowerCase();
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is wearing " + ChatColor.AQUA + cn);
                    ItemStack ci = new ItemStack(Chestplate);
                    armor.addItem(ci);
                }else{
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is not wearing a chestplate");
                }
                if (leggings != null) {
                    String ln = leggings.getType().name().toLowerCase();
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is wearing " + ChatColor.AQUA + ln);
                    ItemStack li = new ItemStack(leggings);
                    armor.addItem(li);
                }else{
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is not wearing leggings");
                }
                if (boots != null) {
                    String bn = boots.getType().name().toLowerCase();
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is wearing " + ChatColor.AQUA + bn);
                    ItemStack bi = new ItemStack(boots);
                    armor.addItem(bi);
                }else{
                    System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + " is not wearing boots");
                }
                double health = target.getHealth();
                System.out.println(ChatColor.AQUA + td + ChatColor.GOLD + "'s health is " + health);
                ItemStack hearts = new ItemStack(Material.APPLE);
                ItemMeta heartMeta = hearts.getItemMeta();
                heartMeta.setDisplayName(ChatColor.RED + "Health is " + health);
                hearts.setItemMeta(heartMeta);
                armor.addItem(hearts);
                ItemStack inhand = new ItemStack(equipment.getItemInMainHand());
                armor.addItem(inhand);
                ItemStack name = new ItemStack(Material.PLAYER_HEAD);
                ItemMeta nameMeta = name.getItemMeta();
                nameMeta.setDisplayName(ChatColor.GOLD + "Target player name: " + ChatColor.AQUA +  td);
                name.setItemMeta(nameMeta);
                armor.addItem(name);
                player.openInventory(armor);
            }else{
                player.sendMessage(ChatColor.GOLD + "Please get the permission called; getarmor.getarmor");
            }
        }

        return true;
    }
}
