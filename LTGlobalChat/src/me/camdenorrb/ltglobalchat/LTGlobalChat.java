package me.camdenorrb.ltglobalchat;

import me.camdenorrb.ltglobalchat.commands.GlobalCmd;
import me.camdenorrb.ltglobalchat.commands.SpyCmd;
import me.camdenorrb.ltglobalchat.events.PlayerListen;
import me.camdenorrb.ltglobalchat.utils.ChatUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.UUID;

/**
 * Created by kingCam on 3/12/16.
 */
public class LTGlobalChat extends JavaPlugin {

    private String spyEnabled, spyDisabled, globalEnabled, globalDisabled;
    private final HashSet<UUID> globalHolder = new HashSet<>(), spyHolder = new HashSet<>();

    @Override
    public void onEnable() {
        initConfig();
        getCommand("spy").setExecutor(new SpyCmd(spyHolder, spyEnabled, spyDisabled));
        getCommand("global").setExecutor(new GlobalCmd(globalEnabled, globalDisabled, globalHolder));
        getServer().getPluginManager().registerEvents(new PlayerListen(globalHolder, spyHolder), this);
    }

    private void initConfig() {
        saveDefaultConfig();
        spyEnabled = ChatUtils.format(getConfig().getString("SpyEnabled", "&dYour SpyMode is now &aEnabled!"));
        spyDisabled = ChatUtils.format(getConfig().getString("SpyDisabled", "&dYour SpyMode is now &cDisabled!"));
        globalEnabled = ChatUtils.format(getConfig().getString("GlobalEnabled", "&dYour GlobalChat is now &aEnabled!"));
        globalDisabled = ChatUtils.format(getConfig().getString("GlobalDisabled", "&dYour GlobalChat is now &cDisabled!"));
    }

    public String getSpyEnabled() {
        return spyEnabled;
    }

    public String getSpyDisabled() {
        return spyDisabled;
    }

    public HashSet<UUID> getSpyHolder() {
        return spyHolder;
    }

    public String getGlobalEnabled() {
        return globalEnabled;
    }

    public String getGlobalDisabled() {
        return globalDisabled;
    }

    public HashSet<UUID> getGlobalHolder() {
        return globalHolder;
    }

}
