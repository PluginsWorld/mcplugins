package com.github.ukraine1449.armorstandgui;

import com.github.ukraine1449.armorstandgui.Commands.asgui;
import com.github.ukraine1449.armorstandgui.Events.MenuHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class ArmorStandGUI extends JavaPlugin {
    public HashMap<Player, ArmorStand> armorstands = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("asgui").setExecutor(new asgui(this));
        getServer().getPluginManager().registerEvents(new MenuHandler(this), this);
    }



    public void openMainMenu(Player player){
        Inventory main_menu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "Armorstand GUI");

        ItemStack create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta cm = create.getItemMeta();
        cm.setDisplayName("Create");
        ArrayList<String> create_lore = new ArrayList<>();
        create_lore.add(ChatColor.GOLD + "Creates a new armor stand");
        cm.setLore(create_lore);
        create.setItemMeta(cm);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta clm = close.getItemMeta();
        clm.setDisplayName(ChatColor.RED + "Close GUI");
        close.setItemMeta(clm);

        main_menu.setItem(0, create);
        main_menu.setItem(8, close);
        player.openInventory(main_menu);
    }
    public void openCreateMenu(Player player){
        Inventory create_menu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "Create an armor stand");
        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemMeta am = arms.getItemMeta();
        am.setDisplayName("Arms");
        arms.setItemMeta(am);
        ItemStack glow = new ItemStack(Material.GLOWSTONE);
        ItemMeta gm = glow.getItemMeta();
        gm.setDisplayName("Glow");
        glow.setItemMeta(gm);
        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta arm = armor.getItemMeta();
        arm.setDisplayName("Armor");
        armor.setItemMeta(arm);
        ItemStack base = new ItemStack(Material.STONE_SLAB);
        ItemMeta bm = base.getItemMeta();
        bm.setDisplayName("Base");
        base.setItemMeta(bm);
        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemStack delete = new ItemStack(Material.RED_WOOL);
        ItemMeta cm = confirm.getItemMeta();
        cm.setDisplayName("Confirm");
        confirm.setItemMeta(cm);
        ItemMeta dm = delete.getItemMeta();
        dm.setDisplayName("Cancel");
        delete.setItemMeta(dm);

        create_menu.setItem(0, arms);
        create_menu.setItem(1, glow);
        create_menu.setItem(2, armor);
        create_menu.setItem(3, base);
        create_menu.setItem(7, confirm);
        create_menu.setItem(8, delete);



        player.openInventory(create_menu);
    }
    public void openConfirmMenu(Player player, Material option){
        Inventory confirm_new = Bukkit.createInventory(player, 36, ChatColor.GREEN + "Connfirm menu");
        ItemStack option_item = new ItemStack(option);
        ItemMeta option_meta = option_item.getItemMeta();

        if(option == Material.ARMOR_STAND){
            option_meta.setDisplayName("Give arms?");
            option_item.setItemMeta(option_meta);
        }else if(option == Material.GLOWSTONE){
            option_meta.setDisplayName("Give glow?");
            option_item.setItemMeta(option_meta);
        }else if(option == Material.STONE_SLAB) {
            option_meta.setDisplayName("Add base?");
            option_item.setItemMeta(option_meta);
        }
        ItemStack yes = new ItemStack(Material.GREEN_WOOL);
        ItemMeta ym = yes.getItemMeta();
        ym.setDisplayName(ChatColor.GREEN + "Yes");
        yes.setItemMeta(ym);
        ItemStack no = new ItemStack(Material.RED_WOOL);
        ItemMeta nm = no.getItemMeta();
        nm.setDisplayName(ChatColor.RED + "No");

        confirm_new.setItem(13, option_item);
        confirm_new.setItem(21, yes);
        confirm_new.setItem(23, no);
        player.openInventory(confirm_new);
    }
    public void openArmorMenu(Player player) {
        Inventory armormenu = Bukkit.createInventory(player, 45, ChatColor.BLUE + "Choose armor");
        ItemStack dh = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack db = new ItemStack(Material.DIAMOND_BOOTS);

        ItemStack nh = new ItemStack(Material.NETHERITE_HELMET);
        ItemStack nc = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemStack nl = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemStack nb = new ItemStack(Material.NETHERITE_BOOTS);

        ItemStack gh = new ItemStack(Material.GOLDEN_HELMET);
        ItemStack gc = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemStack gl = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemStack gb = new ItemStack(Material.GOLDEN_BOOTS);

        ItemStack ih = new ItemStack(Material.IRON_HELMET);
        ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack il = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack ib = new ItemStack(Material.IRON_BOOTS);

        ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS);

        ItemStack lh = new ItemStack(Material.LEATHER_HELMET);
        ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack lb = new ItemStack(Material.LEATHER_BOOTS);

        ItemStack turthelm = new ItemStack(Material.TURTLE_HELMET);
        ItemStack pumpkin = new ItemStack(Material.CARVED_PUMPKIN);
        ItemStack elytra = new ItemStack(Material.ELYTRA);



        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemMeta conmet = confirm.getItemMeta();
        conmet.setDisplayName(ChatColor.GREEN + "Confirm");
        confirm.setItemMeta(conmet);

        armormenu.setItem(0, lh);
        armormenu.setItem(9, lc);
        armormenu.setItem(18, ll);
        armormenu.setItem(27, lb);

        armormenu.setItem(1, gh);
        armormenu.setItem(10, gc);
        armormenu.setItem(19, gl);
        armormenu.setItem(28, gb);

        armormenu.setItem(2, ch);
        armormenu.setItem(11, cc);
        armormenu.setItem(20, cl);
        armormenu.setItem(29, cb);

        armormenu.setItem(6, ih);
        armormenu.setItem(15, ic);
        armormenu.setItem(24, il);
        armormenu.setItem(33, ib);

        armormenu.setItem(7, dh);
        armormenu.setItem(16, dc);
        armormenu.setItem(25, dl);
        armormenu.setItem(34, db);

        armormenu.setItem(8, nh);
        armormenu.setItem(17, nc);
        armormenu.setItem(26, nl);
        armormenu.setItem(35, nb);

        armormenu.setItem(4, turthelm);
        armormenu.setItem(6, pumpkin);
        armormenu.setItem(10, elytra);
        armormenu.setItem(31, confirm);
        player.openInventory(armormenu);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
