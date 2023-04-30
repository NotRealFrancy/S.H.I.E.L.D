package org.github.notrealfrancy.shield;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Shield extends JavaPlugin {

    @Getter private static Shield instance;

    @Override
    public void onEnable() {
        Shield.instance = this;

        Bukkit.getConsoleSender().sendMessage(Shield.getPrefix() + "Plugin abilitato!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Shield.getPrefix() + "Plugin disabilitato!");
    }

    public static String getPrefix() {
        return String.valueOf(ChatColor.BOLD) + ChatColor.BLUE + "SHIELD" + ChatColor.RESET + ChatColor.DARK_GRAY + " >> ";
    }
}
