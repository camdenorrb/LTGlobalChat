package me.camdenorrb.ltglobalchat.config;

import org.bukkit.configuration.file.FileConfiguration;

import static me.camdenorrb.ltglobalchat.struct.Constants.*;
import static me.camdenorrb.ltglobalchat.utils.ChatUtils.format;

public final class LTConfig {

	private final String spyEnabledMsg, spyDisabledMsg, globalEnabledMsg, globalDisabledMsg;


	public LTConfig(final String spyEnabledMsg, final String spyDisabledMsg, final String globalEnabledMsg, final String globalDisabledMsg) {
		this.spyEnabledMsg = spyEnabledMsg;
		this.spyDisabledMsg = spyDisabledMsg;
		this.globalEnabledMsg = globalEnabledMsg;
		this.globalDisabledMsg = globalDisabledMsg;
	}


	public static LTConfig from(final FileConfiguration config) {

		final String spyEnabledMsg = format(config.getString("SpyEnabled", DEFAULT_SPY_ENABLE_MSG));
		final String spyDisabledMsg = format(config.getString("SpyDisabled", DEFAULT_SPY_DISABLE_MSG));
		final String globalEnabledMsg = format(config.getString("GlobalEnabled", DEFAULT_GLOBAL_ENABLE_MSG));
		final String globalDisabledMsg = format(config.getString("GlobalDisabled", DEFAULT_GLOBAL_DISABLE_MSG));

		return new LTConfig(spyEnabledMsg, spyDisabledMsg, globalEnabledMsg, globalDisabledMsg);
	}


	public String spyEnabledMsg() {
		return spyEnabledMsg;
	}

	public String spyDisabledMsg() {
		return spyDisabledMsg;
	}

	public String globalEnabledMsg() {
		return globalEnabledMsg;
	}

	public String globalDisabledMsg() {
		return globalDisabledMsg;
	}

}
