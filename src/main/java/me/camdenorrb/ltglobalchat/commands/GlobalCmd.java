package me.camdenorrb.ltglobalchat.commands;

import me.camdenorrb.ltglobalchat.LTGlobalChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;


public final class GlobalCmd implements CommandExecutor {

    private final LTGlobalChat plugin;


    public GlobalCmd(final LTGlobalChat plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] args) {

        if (sender instanceof ConsoleCommandSender) return false;

        final UUID uuid = ((Player) sender).getUniqueId();
	    final HashSet<UUID> globalHolder = plugin.getGlobalHolder();

        if (!globalHolder.remove(uuid)) {
            globalHolder.add(uuid);
            sender.sendMessage(plugin.getLtConfig().globalEnabledMsg());

        } else sender.sendMessage(plugin.getLtConfig().globalDisabledMsg());

        return true;
    }

}
