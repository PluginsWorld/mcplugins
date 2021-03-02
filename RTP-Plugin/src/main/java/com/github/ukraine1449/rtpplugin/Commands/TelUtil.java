package com.github.ukraine1449.rtpplugin.Commands;

import com.github.ukraine1449.rtpplugin.RTPPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.Random;

public class TelUtil {
static RTPPlugin plugin;

    public TelUtil(RTPPlugin plugin) {
        TelUtil.plugin = plugin;
    }
    public static HashSet<Material> bad_blocks = new HashSet<>();

    static{
        bad_blocks.add(Material.LAVA);
        bad_blocks.add(Material.MAGMA_BLOCK);
        bad_blocks.add(Material.FIRE);
        bad_blocks.add(Material.SOUL_FIRE);
        bad_blocks.add(Material.CAMPFIRE);
        bad_blocks.add(Material.SOUL_CAMPFIRE);
        bad_blocks.add(Material.WATER);
    }

    public static Location generateLocation(Player player){

        int y = 150;
        //Generate Random Location
        Random random = new Random();
        int np = random.nextInt(3);
        if(np == 0){
            int x = random.nextInt(plugin.getConfig().getInt("x"));
            int z = random.nextInt(plugin.getConfig().getInt("z"));
            Location randomLocation = new Location(player.getWorld(), x, y, z);
            y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
            int c = y+1;
            randomLocation.setY(c);
            return randomLocation;
        }else if(np == 1){
            int nz = random.nextInt(plugin.getConfig().getInt("nz"));

            int x = random.nextInt(plugin.getConfig().getInt("x"));
            int z = 0-nz;
            Location randomLocation = new Location(player.getWorld(), x, y, z);
            y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
            int c = y+1;
            randomLocation.setY(c);
            return randomLocation;
        }
        else if(np == 2){
            int nx = random.nextInt(plugin.getConfig().getInt("nx"));
            int z = random.nextInt(plugin.getConfig().getInt("z"));

            int x = 0-nx;
            Location randomLocation = new Location(player.getWorld(), x, y, z);
            y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
            int c = y+1;
            randomLocation.setY(c);
            return randomLocation;
        }
        else {
            int nx = random.nextInt(plugin.getConfig().getInt("nx"));
            int nz = random.nextInt(plugin.getConfig().getInt("nz"));

            int x = 0-nx;
            int z = 0-nz;
            Location randomLocation = new Location(player.getWorld(), x, y, z);
            y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
            int c = y+1;
            randomLocation.setY(c);
            return randomLocation;
        }

    }


    public static boolean isLocationSafe(Location location){

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        //Get instances of the blocks around where the player would spawn
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block block = location.getWorld().getBlockAt(x, y - 2, z);
        Block three = location.getWorld().getBlockAt(x, y - 3, z);
        Block inside = location.getWorld().getBlockAt(x, y, z);


        //Check to see if the surroundings are safe or not
        return !(bad_blocks.contains(below.getType()) || (block.getType().isSolid()) || (three.getType().isSolid()) || (inside.getType().isSolid()));
    }

}
