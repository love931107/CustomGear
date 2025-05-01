package me.miko.customgear;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGear extends JavaPlugin {

    private static CustomGear instance;

    @Override
    public void onEnable() {
        instance = this;

        // 註冊事件與指令
        Bukkit.getPluginManager().registerEvents(new ForgeListener(), this);
        getCommand("token").setExecutor(new TokenCommand());
        getCommand("forgevendor").setExecutor(new VendorCommand());

        saveDefaultConfig();
        getLogger().info("✅ CustomGear 插件已啟動！");
    }

    @Override
    public void onDisable() {
        getLogger().info("❌ CustomGear 插件已關閉。");
    }

    public static CustomGear getInstance() {
        return instance;
    }
}
