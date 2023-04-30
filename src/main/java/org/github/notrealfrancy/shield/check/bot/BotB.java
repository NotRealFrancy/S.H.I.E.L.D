package org.github.notrealfrancy.shield.check.bot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.github.notrealfrancy.shield.check.Check;
import org.github.notrealfrancy.shield.check.CheckCategory;
import org.github.notrealfrancy.shield.check.CheckType;

public class BotB extends Check {

    public BotB() {
        super("Bot", "B", CheckCategory.login_countdown, CheckType.bot);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
    }

}
