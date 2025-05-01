package me.miko.customgear;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VendorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length > 0 && args[0].equalsIgnoreCase("spawn")) {
            Location loc = player.getLocation();
            ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            stand.setVisible(false);
            stand.setCustomName("§6鍛造商人");
            stand.setCustomNameVisible(true);
            stand.setGravity(false);
            stand.setMarker(true);
            stand.setHelmet(new ItemStack(Material.GOLD_BLOCK));
            player.sendMessage("§a鍛造商人已召喚！");
        }

        return true;
    }
}
