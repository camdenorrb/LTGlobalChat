package me.camdenorrb.ltglobalchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;

import static me.camdenorrb.ltglobalchat.LTGlobalChat.getGlobalHolder;
import static me.camdenorrb.ltglobalchat.LTGlobalChat.getLtConfig;


public class GlobalCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender) return false;

        final UUID uuid = ((Player) sender).getUniqueId();
	    final HashSet<UUID> globalHolder = getGlobalHolder();

        if (!globalHolder.remove(uuid)) {
            globalHolder.add(uuid);
            sender.sendMessage(getLtConfig().globalEnabledMsg());

        } else sender.sendMessage(getLtConfig().globalDisabledMsg());

        return true;
    }

}
