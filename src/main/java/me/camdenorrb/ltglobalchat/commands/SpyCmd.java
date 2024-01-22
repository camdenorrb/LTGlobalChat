package me.camdenorrb.ltglobalchat.commands;

import me.camdenorrb.ltglobalchat.LTGlobalChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.UUID;

import static me.camdenorrb.ltglobalchat.LTGlobalChat.*;


public final class SpyCmd implements CommandExecutor {

    private final LTGlobalChat plugin;


    public SpyCmd(final LTGlobalChat plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] args) {

        if (sender instanceof ConsoleCommandSender) return false;

        final UUID uuid = ((Player) sender).getUniqueId();
        final HashSet<UUID> spyHolder = plugin.getSpyHolder();

        if (!spyHolder.remove(uuid)) {
            spyHolder.add(uuid);
            sender.sendMessage(plugin.getLtConfig().spyEnabledMsg());

        } else sender.sendMessage(plugin.getLtConfig().spyDisabledMsg());

        return true;
    }
}
