package com.github.ukraine1449.armorstandgui.Events;

import com.github.ukraine1449.armorstandgui.ArmorStandGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuHandler implements Listener {
    ArmorStandGUI plugin;

    public MenuHandler(ArmorStandGUI plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onMenuClick(InventoryClickEvent event){
        final String Main_menu = ChatColor.BLUE + "Armorstand GUI";
        final String Create_menu = ChatColor.BLUE + "Create an armor stand";
        final String CONFRIM_MENU = ChatColor.GREEN + "Connfirm menu";
        final String ARMMEN = ChatColor.BLUE + "Choose armor";
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Armorstand GUI")) {
            if(event.getCurrentItem() == null){
                return;
            }else {
                switch(event.getCurrentItem().getType()){
                    case ARMOR_STAND:
                        player.sendMessage("Opened armor stand menu");
                        event.setCancelled(true);
                        player.closeInventory();
                        plugin.openCreateMenu(player);
                        break;
                    case BARRIER:
                        player.sendMessage("Closing main menu");
                        event.setCancelled(true);
                        player.closeInventory();
                        break;
                }
            }
        }else if (event.getView().getTitle().equalsIgnoreCase(Create_menu)){
            if(event.getCurrentItem() == null){
                return;
            }else {
                if(!plugin.armorstands.containsKey(player)){
                    ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                    stand.setVisible(false);
                    plugin.armorstands.put(player, stand);
                }
                switch(event.getCurrentItem().getType()) {
                    case ARMOR_STAND:
                        player.sendMessage(ChatColor.GOLD + "Add arms?");
                        plugin.openConfirmMenu(player, Material.ARMOR_STAND);
                        event.setCancelled(true);
                        break;
                    case GLOWSTONE:
                        player.sendMessage(ChatColor.GOLD + "Add glow?");
                        plugin.openConfirmMenu(player, Material.GLOWSTONE);
                        event.setCancelled(true);
                        break;
                    case LEATHER_CHESTPLATE:
                        player.sendMessage(ChatColor.GOLD + "Choose armor");
                        event.setCancelled(true);
                        plugin.openArmorMenu(player);
                        break;
                    case STONE_SLAB:
                        player.sendMessage(ChatColor.GOLD + "Add base?");
                        plugin.openConfirmMenu(player, Material.STONE_SLAB);
                        event.setCancelled(true);
                        break;
                    case GREEN_WOOL:
                        player.sendMessage(ChatColor.GOLD + "Created armorstand");
                        if(plugin.armorstands.containsKey(player)){
                            ArmorStand stand = plugin.armorstands.get(player);
                            stand.setVisible(true);
                            plugin.armorstands.remove(player);
                        }

                        player.closeInventory();
                        break;
                    case RED_WOOL:
                        player.sendMessage(ChatColor.GOLD + "Deleted armor stand");
                        if(plugin.armorstands.containsKey(player)){
                            ArmorStand stand = plugin.armorstands.get(player);
                            stand.remove();
                            plugin.armorstands.remove(player);
                        }
                        player.closeInventory();
                        break;

                }

            }
        }
        else if (event.getView().getTitle().equalsIgnoreCase(CONFRIM_MENU)){
            if(event.getCurrentItem() == null){
                return;
            }else {
                if(event.getClickedInventory().contains(Material.ARMOR_STAND)){
                    switch (event.getCurrentItem().getType()){
                        case GREEN_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Confirmed");
                            if(plugin.armorstands.containsKey(player)){
                                ArmorStand stand = plugin.armorstands.get(player);
                                stand.setArms(true);
                            }event.setCancelled(true);
                            plugin.openCreateMenu(player);
                            break;
                        case RED_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Canceled");
                            if(plugin.armorstands.containsKey(player)){
                                ArmorStand stand = plugin.armorstands.get(player);
                                stand.setArms(false);
                            }event.setCancelled(true);
                            plugin.openCreateMenu(player);
                            break;
                    }
                }            else if(event.getClickedInventory().contains(Material.GLOWSTONE)){
                    switch (event.getCurrentItem().getType()) {
                        case GREEN_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Option Confirmed");
                            if (plugin.armorstands.containsKey(player)){
                                ArmorStand stand = plugin.armorstands.get(player);
                                stand.setGlowing(true);
                                stand.setVisible(false);
                            }
                            event.setCancelled(true);
                            plugin.openCreateMenu(player);
                            break;
                        case RED_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Cancelled Option");
                            if (plugin.armorstands.containsKey(player)){
                                ArmorStand stand = plugin.armorstands.get(player);
                                stand.setGlowing(false);
                            }
                            event.setCancelled(true);
                            plugin.openCreateMenu(player);
                            break;
                    }
                }
                else if(event.getClickedInventory().contains(Material.STONE_SLAB)){
                    switch (event.getCurrentItem().getType()){
                        case GREEN_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Confirmed");
                            if(plugin.armorstands.containsKey(player)){
                                ArmorStand stand = plugin.armorstands.get(player);
                                stand.setBasePlate(true);
                            }
                            event.setCancelled(true);
                            plugin.openCreateMenu(player);
                            break;
                        case RED_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Canceled");
                            if(plugin.armorstands.containsKey(player)){
                                ArmorStand stand = plugin.armorstands.get(player);
                                stand.setBasePlate(false);
                            }
                            event.setCancelled(true);
                            plugin.openCreateMenu(player);
                            break;
                    }
                }


            }
        } else if (event.getView().getTitle().equalsIgnoreCase(ARMMEN)){
            if(event.getCurrentItem() == null){
                return;
            }else{
                if(plugin.armorstands.containsKey(player)){
                    ArmorStand stand = plugin.armorstands.get(player);
                    switch(event.getCurrentItem().getType()) {
                        case LEATHER_HELMET:
                            if(stand.getHelmet().getType() == Material.LEATHER_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.LEATHER_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set leather helmet");
                            }
                            event.setCancelled(true);
                            break;
                        case LEATHER_CHESTPLATE:
                            if(stand.getChestplate().getType() == Material.LEATHER_CHESTPLATE){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                                player.sendMessage(ChatColor.GOLD + "Set leather chestplate");
                            }
                            event.setCancelled(true);
                            break;
                        case LEATHER_LEGGINGS:
                            if(stand.getLeggings().getType() == Material.LEATHER_LEGGINGS){
                                stand.setLeggings(null);
                            }else {
                                stand.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                                player.sendMessage(ChatColor.GOLD + "Set leather leggings");
                            }
                            event.setCancelled(true);
                            break;
                        case LEATHER_BOOTS:
                            if(stand.getBoots().getType() == Material.LEATHER_BOOTS){
                                stand.setBoots(null);
                            }else {
                                stand.setBoots(new ItemStack(Material.LEATHER_BOOTS));
                                player.sendMessage(ChatColor.GOLD + "Set leather boots");
                            }
                            event.setCancelled(true);
                            break;


                        case CHAINMAIL_HELMET:
                            if(stand.getHelmet().getType() == Material.CHAINMAIL_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set chainmail helmet");
                            }
                            event.setCancelled(true);
                            break;
                        case CHAINMAIL_CHESTPLATE:
                            if(stand.getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                                player.sendMessage(ChatColor.GOLD + "Set chainmail chestplate");
                            }
                            event.setCancelled(true);
                            break;
                        case CHAINMAIL_LEGGINGS:
                            if(stand.getLeggings().getType() == Material.CHAINMAIL_LEGGINGS){
                                stand.setLeggings(null);
                            }else {
                                stand.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                                player.sendMessage(ChatColor.GOLD + "Set chainmail leggings");
                            }
                            event.setCancelled(true);
                            break;
                        case CHAINMAIL_BOOTS:
                            if(stand.getBoots().getType() == Material.CHAINMAIL_BOOTS){
                                stand.setBoots(null);
                            }else {
                                stand.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                                player.sendMessage(ChatColor.GOLD + "Set chainmail boots");
                            }
                            event.setCancelled(true);
                            break;



                        case GOLDEN_HELMET:
                            if(stand.getHelmet().getType() == Material.GOLDEN_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.GOLDEN_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set golden helmet");
                            }
                            event.setCancelled(true);
                            break;
                        case GOLDEN_CHESTPLATE:
                            if(stand.getChestplate().getType() == Material.GOLDEN_CHESTPLATE){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
                                player.sendMessage(ChatColor.GOLD + "Set golden chestplate");
                            }
                            event.setCancelled(true);
                            break;
                        case GOLDEN_LEGGINGS:
                            if(stand.getLeggings().getType() == Material.GOLDEN_LEGGINGS){
                                stand.setLeggings(null);
                            }else {
                                stand.setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
                                player.sendMessage(ChatColor.GOLD + "Set golden leggings");
                            }
                            event.setCancelled(true);
                            break;
                        case GOLDEN_BOOTS:
                            if(stand.getBoots().getType() == Material.GOLDEN_BOOTS){
                                stand.setBoots(null);
                            }else {
                                stand.setBoots(new ItemStack(Material.GOLDEN_BOOTS));
                                player.sendMessage(ChatColor.GOLD + "Set golden boots");
                            }
                            event.setCancelled(true);
                            break;


                        case IRON_HELMET:
                            if(stand.getHelmet().getType() == Material.IRON_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.IRON_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set iron helmet");
                            }
                            event.setCancelled(true);
                            break;
                        case IRON_CHESTPLATE:
                            if(stand.getChestplate().getType() == Material.IRON_CHESTPLATE){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                                player.sendMessage(ChatColor.GOLD + "Set iron chestplate");
                            }
                            event.setCancelled(true);
                            break;
                        case IRON_LEGGINGS:
                            if(stand.getLeggings().getType() == Material.IRON_LEGGINGS){
                                stand.setLeggings(null);
                            }else {
                                stand.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                                player.sendMessage(ChatColor.GOLD + "Set iron leggings");
                            }
                            event.setCancelled(true);
                            break;
                        case IRON_BOOTS:
                            if(stand.getBoots().getType() == Material.IRON_BOOTS){
                                stand.setBoots(null);
                            }else {
                                stand.setBoots(new ItemStack(Material.IRON_BOOTS));
                                player.sendMessage(ChatColor.GOLD + "Set iron boots");
                            }
                            event.setCancelled(true);
                            break;


                        case DIAMOND_HELMET:
                            if(stand.getHelmet().getType() == Material.DIAMOND_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set diamond helmet");
                            }
                            event.setCancelled(true);
                            break;
                        case DIAMOND_CHESTPLATE:
                            if(stand.getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                                player.sendMessage(ChatColor.GOLD + "Set diamond chestplate");
                            }
                            event.setCancelled(true);
                            break;
                        case DIAMOND_LEGGINGS:
                            if(stand.getLeggings().getType() == Material.DIAMOND_LEGGINGS){
                                stand.setLeggings(null);
                            }else {
                                stand.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                                player.sendMessage(ChatColor.GOLD + "Set diamond leggings");
                            }
                            event.setCancelled(true);
                            break;
                        case DIAMOND_BOOTS:
                            if(stand.getBoots().getType() == Material.DIAMOND_BOOTS){
                                stand.setBoots(null);
                            }else {
                                stand.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                                player.sendMessage(ChatColor.GOLD + "Set diamond boots");
                            }
                            event.setCancelled(true);
                            break;

                        case NETHERITE_HELMET:
                            if(stand.getHelmet().getType() == Material.NETHERITE_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.NETHERITE_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set netherite helmet");
                            }
                            event.setCancelled(true);
                            break;
                        case NETHERITE_CHESTPLATE:
                            if(stand.getChestplate().getType() == Material.NETHERITE_CHESTPLATE){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
                                player.sendMessage(ChatColor.GOLD + "Set netherite chestplate");
                            }
                            event.setCancelled(true);
                            break;
                        case NETHERITE_LEGGINGS:
                            if(stand.getLeggings().getType() == Material.NETHERITE_LEGGINGS){
                                stand.setLeggings(null);
                            }else {
                                stand.setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
                                player.sendMessage(ChatColor.GOLD + "Set netherite leggings");
                            }
                            event.setCancelled(true);
                            break;
                        case NETHERITE_BOOTS:
                            if(stand.getBoots().getType() == Material.NETHERITE_BOOTS){
                                stand.setBoots(null);
                            }else {
                                stand.setBoots(new ItemStack(Material.NETHERITE_BOOTS));
                                player.sendMessage(ChatColor.GOLD + "Set netherite boots");
                            }
                            event.setCancelled(true);
                            break;

                        case TURTLE_HELMET:
                            if(stand.getHelmet().getType() == Material.TURTLE_HELMET){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.TURTLE_HELMET));
                                player.sendMessage(ChatColor.GOLD + "Set turtle helmet");
                            }
                        case CARVED_PUMPKIN:
                            if(stand.getHelmet().getType() == Material.CARVED_PUMPKIN){
                                stand.setHelmet(null);
                            }else {
                                stand.setHelmet(new ItemStack(Material.CARVED_PUMPKIN));
                                player.sendMessage(ChatColor.GOLD + "Set carved pumpkin");
                            }
                            event.setCancelled(true);
                            break;
                        case ELYTRA:
                            if(stand.getChestplate().getType() == Material.ELYTRA){
                                stand.setChestplate(null);
                            }else {
                                stand.setChestplate(new ItemStack(Material.ELYTRA));
                                player.sendMessage(ChatColor.GOLD + "Set Elytra");
                            }
                            event.setCancelled(true);
                            break;
                        case GREEN_WOOL:
                            player.sendMessage(ChatColor.GOLD + "Armor confirmed");
                            plugin.openCreateMenu(player);
                            event.setCancelled(true);

                    }
                }
            }


        }
    }
}