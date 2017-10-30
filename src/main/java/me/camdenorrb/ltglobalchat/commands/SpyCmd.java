package me.camdenorrb.ltglobalchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;

import static me.camdenorrb.ltglobalchat.LTGlobalChat.*;


public class SpyCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender) return false;


        final UUID uuid = ((Player) sender).getUniqueId();
        final HashSet<UUID> spyHolder = getSpyHolder();

        if (!spyHolder.remove(uuid)) {
            spyHolder.add(uuid);
            sender.sendMessage(getLtConfig().spyEnabledMsg());

        } else sender.sendMessage(getLtConfig().spyDisabledMsg());

        return true;
    }
}
