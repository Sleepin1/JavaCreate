import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FishingCmds implements CommandExecutor {
    private static Main pl;

    public FishingCmds(Main plugin) {
        pl = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
            Player p = (Player) commandSender;
            ItemStack i = p.getInventory().getItemInMainHand();
            if(p.getInventory().getItemInMainHand().getType() == Material.FISHING_ROD) {
                FishingRod fr = new FishingRod(p, pl);
                if(args.length == 0) { //Lists the upgrades or attempts to upgrade the fishing rod
                    p.sendMessage(ChatColor.AQUA + "Lure: " + fr.getLure() + "\nLuck: " + fr.getLuck() + "\nDouble Catch: " + fr.getDoubleCatch());
                } else if (p.getLevel() > 30) {
                    if (args[0].equalsIgnoreCase("lure")) {
                        fr.upgradeLure();
                        p.sendMessage(ChatColor.AQUA + "Your fishing rod was upgraded if it did not surpass limit!");
                    }else if (args[0].equalsIgnoreCase("luck")) {
                        fr.upgradeLuck();
                        p.sendMessage(ChatColor.AQUA + "Your fishing rod was upgraded if it did not surpass limit!");
                    }else if (args[0].equalsIgnoreCase("double")) {
                        fr.upgradeDoubleCatch();
                        p.sendMessage(ChatColor.AQUA + "Your fishing rod was upgraded if it did not surpass limit!");
                    }
                } else {
                    p.sendMessage(ChatColor.AQUA + "You need 30exp to upgrade your fishing rod!");
                }

            } else {
                p.sendMessage(ChatColor.AQUA + "You must be holding a fishing rod!");
            }
        return true;
    }
}
