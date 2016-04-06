package me.camdenorrb.ltglobalchat.commands;

import me.camdenorrb.ltglobalchat.LTGlobalChat;
import me.camdenorrb.ltglobalchat.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * Created by kingCam on 3/13/16.
 */
public class SpyCmd implements CommandExecutor {

    private final String enabledMsg = LTGlobalChat.getEnabled(), disabled = LTGlobalChat.getDisabled();
    private final List<UUID> spyHolder = LTGlobalChat.getSpyHolder();
    private final String message;

    public SpyCmd(String message) {
        this.message = message;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof ConsoleCommandSender) return false;
        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        boolean hasPlayer = spyHolder.contains(uuid);
        String enabled = hasPlayer ? disabled : enabledMsg;
        if (hasPlayer) spyHolder.remove(uuid);
        else spyHolder.add(uuid);
        sender.sendMessage(ChatUtils.format(message.replace("%enabled", enabled)));
        return true;
    }
}