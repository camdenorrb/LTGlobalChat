package me.camdenorrb.ltglobalchat.listeners;

import me.camdenorrb.ltglobalchat.LTGlobalChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public final class PlayerListener implements Listener {

	private final LTGlobalChat plugin;

	public PlayerListener(final LTGlobalChat plugin) {
		this.plugin = plugin;
	}

    @EventHandler
    public void onLeave(final PlayerQuitEvent event) {

        final UUID uuid = event.getPlayer().getUniqueId();

        plugin.getSpyHolder().remove(uuid);
        plugin.getGlobalHolder().remove(uuid);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onChat(final AsyncPlayerChatEvent event) {

        final Player player = event.getPlayer();
        final UUID worldUID = player.getWorld().getUID();

	    if (plugin.getGlobalHolder().contains(player.getUniqueId())) return;

	    final HashSet<UUID> spyHolder = plugin.getSpyHolder();
	    final Set<Player> recipients = event.getRecipients();

	    recipients.removeIf(it -> !worldUID.equals(it.getWorld().getUID()) && !spyHolder.contains(it.getUniqueId()));
    }
}
