package me.camdenorrb.ltglobalchat.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static me.camdenorrb.ltglobalchat.LTGlobalChat.getGlobalHolder;
import static me.camdenorrb.ltglobalchat.LTGlobalChat.getSpyHolder;


public final class PlayerListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        final UUID uuid = event.getPlayer().getUniqueId();

        getSpyHolder().remove(uuid);
        getGlobalHolder().remove(uuid);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {

        final Player player = event.getPlayer();
        final UUID worldUID = player.getWorld().getUID();

	    if (getGlobalHolder().contains(player.getUniqueId())) return;

	    final HashSet<UUID> spyHolder = getSpyHolder();
	    final Set<Player> recipients = event.getRecipients();

	    recipients.removeIf(it -> !worldUID.equals(it.getWorld().getUID()) && !spyHolder.contains(it.getUniqueId()));
    }
}
