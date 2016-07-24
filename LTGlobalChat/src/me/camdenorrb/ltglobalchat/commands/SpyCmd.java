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
public class SpyCmd implements CommandExecutor {

    private final HashSet<UUID> spyHolder;
    private final String enabled, disabled;

    public SpyCmd(HashSet<UUID> spyHolder, String enabled, String disabled) {
        this.enabled = enabled;
        this.disabled = disabled;
        this.spyHolder = spyHolder;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender) return false;
        UUID uuid = ((Player) sender).getUniqueId();

        if (!spyHolder.remove(uuid)) {
            spyHolder.add(uuid);
            sender.sendMessage(enabled);

        } else sender.sendMessage(disabled);

        return true;
    }
}
