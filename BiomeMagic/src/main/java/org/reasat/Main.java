package org.reasat;
import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JavaPlugin {
    int time = 10;
    ArrayList<Player> pl = new ArrayList<Player>();
    public void onEnable() {
        System.out.println("Biome Magic Stuff");
    }
    public void onDisable() {
        System.out.println("BYE");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Biome b = e.getTo().getBlock().getBiome();
        if (b == Biome.DESERT) {
            if(p.getInventory().getArmorContents().length >= 4) {
                pl.add(p);
            }
        } else if (b == Biome.ICE_SPIKES || b == Biome.SNOWY_PLAINS || b == Biome.COLD_OCEAN || b == Biome.DEEP_COLD_OCEAN) {
            if(p.getInventory().getArmorContents().length == 0) {
                pl.add(p);
            }
        } else if (pl.contains(p)) {
            pl.remove(p);
        }
    }
    public void startTimer() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : pl) {
                    player.damage(0.5);
                }
            }
        }, time * 20, 20);
    }

}