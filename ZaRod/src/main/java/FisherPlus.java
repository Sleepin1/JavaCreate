import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;


public class FisherPlus implements Listener {
    private static Main pl;

    public FisherPlus(Main plugin) {
        pl = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFish(PlayerFishEvent e) {
        Player p = e.getPlayer();
        FishingRod fr = new FishingRod(p, pl);

        //Magic when Za Fishing Rod is used
        if(e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            int random = (int) (Math.random() * 100) + 1;
            int randomLuck = (int) (Math.random() * 100) + 1;
            if(random <= fr.getDoubleCatch()) {
                ((Item)e.getCaught()).setItemStack(new ItemStack(Material.TROPICAL_FISH, 2));
                p.sendMessage(ChatColor.AQUA + "You Caught Another Fish!");
            }
            if (randomLuck <= fr.getLuck()) {
                ((Item)e.getCaught()).setItemStack(new ItemStack(Material.DIAMOND, 1));
                p.sendMessage(ChatColor.AQUA + "You Got Lucky!");
            }
        }

    }
}
