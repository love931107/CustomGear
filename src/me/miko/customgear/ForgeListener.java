package me.miko.customgear;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ForgeListener implements Listener {

    private final String GUI_TITLE = "§6傳說鍛造爐";

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (block == null || event.getAction().name().contains("LEFT")) return;

        if (block.getType() == Material.LECTERN &&
            player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SCULK_SENSOR) {

            event.setCancelled(true);
            openForgeGUI(player);
        }
    }

    public void openForgeGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, GUI_TITLE);

        ItemStack scroll = new ItemStack(Material.PAPER);
        ItemMeta sm = scroll.getItemMeta();
        sm.setDisplayName("§a請放入升級卷軸");
        scroll.setItemMeta(sm);
        gui.setItem(11, scroll);

        ItemStack gear = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta gm = gear.getItemMeta();
        gm.setDisplayName("§b請放入要強化的裝備");
        gear.setItemMeta(gm);
        gui.setItem(13, gear);

        ItemStack start = new ItemStack(Material.NETHER_STAR);
        ItemMeta smeta = start.getItemMeta();
        smeta.setDisplayName("§e§l開始鍛造");
        start.setItemMeta(smeta);
        gui.setItem(15, start);

        player.openInventory(gui);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        HumanEntity clicker = e.getWhoClicked();
        if (!(clicker instanceof Player)) return;
        Player player = (Player) clicker;

        if (e.getView().getTitle().equals(GUI_TITLE)) {
            e.setCancelled(true);
            if (e.getRawSlot() == 15) {
                player.sendMessage("§a[鍛造成功]！（模擬）");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                player.closeInventory();
            }
        }
    }
}
