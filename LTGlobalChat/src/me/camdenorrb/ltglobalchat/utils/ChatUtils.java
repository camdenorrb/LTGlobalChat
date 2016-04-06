package me.camdenorrb.ltglobalchat.utils;

import org.bukkit.ChatColor;

/**
 * Created by kingCam on 3/13/16.
 */
public class ChatUtils {

    public static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
