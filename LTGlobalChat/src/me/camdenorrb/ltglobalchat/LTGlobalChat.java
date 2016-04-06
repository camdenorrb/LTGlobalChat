package me.camdenorrb.ltglobalchat;

import me.camdenorrb.ltglobalchat.commands.GlobalCmd;
import me.camdenorrb.ltglobalchat.commands.SpyCmd;
import me.camdenorrb.ltglobalchat.events.PlayerListen;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kingCam on 3/12/16.
 */
public class LTGlobalChat extends JavaPlugin {

    private final List<UUID> globalHolder = new ArrayList<>(), spyHolder = new ArrayList<>();
    private String enabled, disabled, spyMsg, globalMsg;

    @Override
    public void onEnable() {
        initConfig();
        getCommand("spy").setExecutor(new SpyCmd(this));
        getCommand("global").setExecutor(new GlobalCmd(this));
        getServer().getPluginManager().registerEvents(new PlayerListen(this), this);
    }

    private void initConfig() {
        saveDefaultConfig();
        spyMsg = getConfig().getString("SpyCommandMsg");
        globalMsg = getConfig().getString("GlobalCommandMsg");
        enabled = getConfig().getString("EnabledMsg");
        disabled = getConfig().getString("DisabledMsg");
        Validate.notNull(spyMsg, "Spy message is not set!");
        Validate.notNull(globalMsg, "Global message is not set!");
        Validate.notNull(enabled, "Enabled message is not set!");
        Validate.notNull(disabled, "Disabled message is not set!");
    }

    public List<UUID> getSpyHolder() {
        return spyHolder;
    }

    public List<UUID> getGlobalHolder() {
        return globalHolder;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getDisabled() {
        return disabled;
    }

    public String getSpyMsg() {
        return spyMsg;
    }

    public String getGlobalMsg() {
        return globalMsg;
    }

}
