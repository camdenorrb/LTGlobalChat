package me.camdenorrb.ltglobalchat.events;

import me.camdenorrb.ltglobalchat.LTGlobalChat;
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

    public PlayerListen(LTGlobalChat ltGlobalChat) {
        globalHolder = ltGlobalChat.getGlobalHolder();
        spyHolder = ltGlobalChat.getSpyHolder();
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID worldUid = player.getWorld().getUID();
        if (globalHolder.contains(player.getUniqueId())) return;
        Iterator<Player> iterator = event.getRecipients().iterator();
        do {
            Player player1 = iterator.next();
            if (!worldUid.equals(player1.getWorld().getUID()) && !spyHolder.contains(player1.getUniqueId())) iterator.remove();
        } while(iterator.hasNext());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        globalHolder.remove(uuid);
        spyHolder.remove(uuid);
    }
}
