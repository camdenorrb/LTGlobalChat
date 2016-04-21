package me.camdenorrb.ltglobalchat.commands;

import me.camdenorrb.ltglobalchat.LTGlobalChat;
import me.camdenorrb.ltglobalchat.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;

/**
 * Created by kingCam on 3/13/16.
 */
public class GlobalCmd implements CommandExecutor {

    private final String enabledMsg, disabled;
    private final HashSet<UUID> players;
    private final String message;

    public GlobalCmd(LTGlobalChat ltGlobalChat) {
        players = ltGlobalChat.getGlobalHolder();
        enabledMsg = ltGlobalChat.getEnabled();
        disabled = ltGlobalChat.getDisabled();
        message = ltGlobalChat.getGlobalMsg();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof ConsoleCommandSender) return false;
        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        boolean hasPlayer = players.contains(uuid);
        String enabled = hasPlayer ? disabled : enabledMsg;
        if (hasPlayer) players.remove(uuid);
        else players.add(uuid);
        sender.sendMessage(ChatUtils.format(message.replace("%enabled", enabled)));
        return true;
    }
}
