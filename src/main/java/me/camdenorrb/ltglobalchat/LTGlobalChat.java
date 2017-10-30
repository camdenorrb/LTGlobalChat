package me.camdenorrb.ltglobalchat;

import me.camdenorrb.ltglobalchat.commands.GlobalCmd;
import me.camdenorrb.ltglobalchat.commands.SpyCmd;
import me.camdenorrb.ltglobalchat.config.LTConfig;
import me.camdenorrb.ltglobalchat.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.UUID;


public final class LTGlobalChat extends JavaPlugin {

    private static LTConfig ltConfig;

	private static final HashSet<UUID> spyHolder = new HashSet<>();
	private static final HashSet<UUID> globalHolder = new HashSet<>();


	@Override
	public void onLoad() {
		saveDefaultConfig();
		ltConfig = LTConfig.from(getConfig());
	}

	@Override
    public void onEnable() {
        getCommand("spy").setExecutor(new SpyCmd());
        getCommand("global").setExecutor(new GlobalCmd());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }


	public static LTConfig getLtConfig() {
		return ltConfig;
	}

	public static HashSet<UUID> getSpyHolder() {
        return spyHolder;
    }

    public static HashSet<UUID> getGlobalHolder() {
        return globalHolder;
    }

}
