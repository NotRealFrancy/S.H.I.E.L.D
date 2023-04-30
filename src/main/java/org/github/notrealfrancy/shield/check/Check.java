package org.github.notrealfrancy.shield.check;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.Listener;

@AllArgsConstructor
public abstract class Check implements Listener {

    @Getter private final String name;
    @Getter private final String discriminator;

    @Getter private final CheckCategory category;
    @Getter private final CheckType type;

}
