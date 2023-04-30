package org.github.notrealfrancy.shield.check.bot;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.github.notrealfrancy.shield.Shield;
import org.github.notrealfrancy.shield.check.Check;
import org.github.notrealfrancy.shield.check.CheckCategory;
import org.github.notrealfrancy.shield.check.CheckType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BotA extends Check {

    private Map<UUID, Integer> bots = new HashMap<>();

    public BotA() {
        super("Bot", "A", CheckCategory.pre_login_bot, CheckType.bot);
    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent e) {
        Player player = Shield.getInstance().getServer().getPlayer(e.getUniqueId());
        String ip = e.getAddress().getHostAddress();

        if(ip.matches(".*\\.bot\\..*")) {
            UUID uuid = e.getUniqueId();
            int count = bots.getOrDefault(uuid, 0) + 1;
            bots.put(uuid, count);

            if(count > 10) {
                long lastLoginTime = player.getLastPlayed();
                long timeSinceLastLogin = System.currentTimeMillis() - lastLoginTime;

                if(timeSinceLastLogin < 300000) {
                    e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, String.valueOf(ChatColor.BOLD) + ChatColor.RED + "S.H.I.E.L.D ti ha rilevato come un'account sospetto!");
                }else {
                    bots.put(uuid, 0);
                }
            }
        }
    }

}
