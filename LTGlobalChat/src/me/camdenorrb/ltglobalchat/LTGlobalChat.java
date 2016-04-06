package me.camdenorrb.ltglobalchat;

import me.camdenorrb.ltglobalchat.commands.GlobalCmd;
import me.camdenorrb.ltglobalchat.commands.SpyCmd;
import me.camdenorrb.ltglobalchat.events.PlayerListen;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kingCam on 3/12/16.
 */
public class LTGlobalChat extends JavaPlugin {

    private static final List<UUID> globalHolder = new ArrayList<>(), spyHolder = new ArrayList<>();
    private static String enabled, disabled;
    private final Configuration config = getConfig();
    private String spyMsg, globalMsg;
    private LTGlobalChat ltGlobalChat = this;

    public static List<UUID> getSpyHolder() {
        return spyHolder;
    }

    public static List<UUID> getGlobalHolder() {
        return globalHolder;
    }

    public static String getEnabled() {
        return enabled;
    }

    public static String getDisabled() {
        return disabled;
    }

    @Override
    public void onEnable() {
        initConfig();
        getCommand("spy").setExecutor(new SpyCmd(spyMsg));
        getCommand("global").setExecutor(new GlobalCmd(globalMsg));
        getServer().getPluginManager().registerEvents(new PlayerListen(), ltGlobalChat);
    }

    @Override
    public void onDisable() {
        ltGlobalChat = null;
    }
    
    private void initConfig() {
        saveDefaultConfig();
        spyMsg = config.getString("SpyCommandMsg");
        globalMsg = config.getString("GlobalCommandMsg");
        enabled = config.getString("EnabledMsg");
        disabled = config.getString("DisabledMsg");
        Validate.notNull(spyMsg, "Spy message is not set!");
        Validate.notNull(globalMsg, "Global message is not set!");
        Validate.notNull(enabled, "Enabled message is not set!");
        Validate.notNull(disabled, "Disabled message is not set!");
    }
}
