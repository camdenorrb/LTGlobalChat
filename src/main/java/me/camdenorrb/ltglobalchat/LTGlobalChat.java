package me.camdenorrb.ltglobalchat;

import me.camdenorrb.ltglobalchat.commands.GlobalCmd;
import me.camdenorrb.ltglobalchat.commands.SpyCmd;
import me.camdenorrb.ltglobalchat.config.LTConfig;
import me.camdenorrb.ltglobalchat.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;


public final class LTGlobalChat extends JavaPlugin {

    private static LTConfig ltConfig;

	private final HashSet<UUID> spyHolder = new HashSet<>();
	private final HashSet<UUID> globalHolder = new HashSet<>();


	@Override
	public void onLoad() {
		saveDefaultConfig();
		ltConfig = LTConfig.from(getConfig());
	}

	@Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("spy")).setExecutor(new SpyCmd(this));
        Objects.requireNonNull(getCommand("global")).setExecutor(new GlobalCmd(this));
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

	@Override
	public void onDisable() {
		spyHolder.clear();
		globalHolder.clear();
	}

	public LTConfig getLtConfig() {
		return ltConfig;
	}

	public HashSet<UUID> getSpyHolder() {
        return spyHolder;
    }

    public HashSet<UUID> getGlobalHolder() {
        return globalHolder;
    }

}
