package me.camdenorrb.ltglobalchat.utils;

import static org.bukkit.ChatColor.translateAlternateColorCodes;


public class ChatUtils {

    public static String format(String text) {
        return translateAlternateColorCodes('&', text);
    }

}
