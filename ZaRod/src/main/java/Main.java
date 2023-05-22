import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    public void onEnable() {
        System.out.println("ZaRod is online!");
        getCommand("zarod").setExecutor(new FishingCmds(this));
        getServer().getPluginManager().registerEvents(new FisherPlus(this), this);
    }
    public void onDisable() {
        System.out.println("BYE");
    }


}