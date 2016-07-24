package me.camdenorrb.ltglobalchat.commands;

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

    private final String enabled, disabled;
    private final HashSet<UUID> globalHolder;

    public GlobalCmd(String enabled, String disabled, HashSet<UUID> globalHolder) {
        this.enabled = enabled;
        this.disabled = disabled;
        this.globalHolder = globalHolder;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender) return false;
        UUID uuid = ((Player) sender).getUniqueId();

        if (!globalHolder.remove(uuid)) {
            globalHolder.add(uuid);
            sender.sendMessage(enabled);

        } else sender.sendMessage(disabled);

        return true;
    }
}
