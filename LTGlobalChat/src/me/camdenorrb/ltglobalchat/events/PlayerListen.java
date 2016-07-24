package me.camdenorrb.ltglobalchat.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by kingCam on 3/14/16.
 */
public class PlayerListen implements Listener {

    private final HashSet<UUID> globalHolder, spyHolder;

    public PlayerListen(HashSet<UUID> globalHolder, HashSet<UUID> spyHolder) {
        this.spyHolder = spyHolder;
        this.globalHolder = globalHolder;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        spyHolder.remove(uuid);
        globalHolder.remove(uuid);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (globalHolder.contains(player.getUniqueId())) return;
        UUID worldUid = player.getWorld().getUID();
        event.getRecipients().removeIf(player1 -> worldUid.equals(player1.getWorld().getUID()) && !spyHolder.contains(player1.getUniqueId());
    }
}
