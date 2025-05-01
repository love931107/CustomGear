package me.miko.customgear;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokenCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length == 0) {
            player.sendMessage("§e你目前擁有 §b100 §e代幣（模擬資料）");
            return true;
        }

        // 未來可擴充：/token give/set/take 玩家 數量
        return true;
    }
}
