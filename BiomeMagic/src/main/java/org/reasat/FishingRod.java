package org.reasat;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FishingRod {
    private int lure = 0;
    private int luck = 0;
    private int doubleCatch = 0;

    public FishingRod(Player p) {
        ItemStack i = p.getInventory().getItemInMainHand();
        ItemMeta im = i.getItemMeta();
        if (im.hasLore()) {
            for (String s : im.getLore()) {
                //Get the current upgrades on the fishing rod.
                if(s.startsWith("Lure: ")) {
                    lure = Integer.getInteger(s.substring(6));
                }
                if(s.startsWith("Luck: ")) {
                    luck = Integer.getInteger(s.substring(6));
                }
                if(s.startsWith("Double Catch: ")) {
                    doubleCatch = Integer.getInteger(s.substring(14));
                }

            }
        } else {
            //Creates lore if it does not exist
            ArrayList<String> sl = new ArrayList<String>();
            sl.add("Lucky Fishing Road");
            sl.add("Lure: 0");
            sl.add("Luck: 0");
            sl.add("Double Catch: 0");
            im.setLore(sl);

        }
    }

    //Za Fishing Rod Upgrades (by 1)
    public void upgradeLure() {
        if(lure>=10) return;
        lure++;

    }
    public void upgradeLuck() {
        if(luck>=10) return;
        luck++;
    }
    public void upgradeDoubleCatch() {
        if(doubleCatch>=10) return;
        doubleCatch++;
    }

}
