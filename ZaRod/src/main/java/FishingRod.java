import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class FishingRod {
    private int lure = 0;
    private int luck = 0;
    private int doubleCatch = 0;
    private Main pl;
    private Player player;
    private PersistentDataContainer c;
    private ItemMeta im;
    private NamespacedKey lureKey;
    private NamespacedKey luckKey;
    private NamespacedKey dCKey;

    public FishingRod(Player p, Main plugin) {
        player = p;
        pl = plugin;
        im = p.getInventory().getItemInMainHand().getItemMeta();
        //Persistent Data Handling aka NBT tags ( first time using them)
        c = im.getPersistentDataContainer();

        lureKey = new NamespacedKey(pl, "lure");
        luckKey = new NamespacedKey(pl, "luck");
        dCKey = new NamespacedKey(pl, "doubleCatch");

        if(c.has(lureKey) && c.has(luckKey) && c.has(dCKey)) {
            //Captures Persistent Data if it does exist
            lure = c.get(lureKey, PersistentDataType.INTEGER);
            luck = c.get(luckKey, PersistentDataType.INTEGER);
            doubleCatch = c.get(dCKey, PersistentDataType.INTEGER);
        } else {
            //Creates Persistent Data if it does not exist
            c.set(lureKey,PersistentDataType.INTEGER, 0);
            c.set(luckKey,PersistentDataType.INTEGER, 0);
            c.set(dCKey,PersistentDataType.INTEGER, 0);
            p.getInventory().getItemInMainHand().setItemMeta(im);
        }
    }

    //Za Fishing Rod Upgrades (by 1)
    public void upgradeLure() {
        if(lure>=10) return;
        lure++;
        c.set(lureKey,PersistentDataType.INTEGER, lure);
        player.getInventory().getItemInMainHand().setItemMeta(im);
        player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.LURE,lure);
        player.setLevel(player.getLevel()-30);
    }
    public void upgradeLuck() {
        if(luck>=5) return;
        luck++;
        c.set(luckKey,PersistentDataType.INTEGER, luck);
        player.getInventory().getItemInMainHand().setItemMeta(im);
        player.setLevel(player.getLevel()-30);
    }
    public void upgradeDoubleCatch() {
        if(doubleCatch>=10) return;
        doubleCatch++;
        c.set(dCKey,PersistentDataType.INTEGER, doubleCatch);
        player.getInventory().getItemInMainHand().setItemMeta(im);
        player.setLevel(player.getLevel()-30);
    }

    //Za Fishing Rod Getters
    public int getLure() {
        return lure;
    }
    public int getLuck() {
        return luck;
    }
    public int getDoubleCatch() {
        return doubleCatch;
    }


}
