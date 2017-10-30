package me.camdenorrb.ltglobalchat.config;


import org.bukkit.configuration.file.FileConfiguration;

import static me.camdenorrb.ltglobalchat.struct.Constants.*;
import static me.camdenorrb.ltglobalchat.utils.ChatUtils.format;


public final class LTConfig {

	private String spyEnabledMsg, spyDisabledMsg, globalEnabledMsg, globalDisabledMsg;


	public LTConfig(String spyEnabledMsg, String spyDisabledMsg, String globalEnabledMsg, String globalDisabledMsg) {
		this.spyEnabledMsg = spyEnabledMsg;
		this.spyDisabledMsg = spyDisabledMsg;
		this.globalEnabledMsg = globalEnabledMsg;
		this.globalDisabledMsg = globalDisabledMsg;
	}


	public static LTConfig from(FileConfiguration config) {

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


	public void setSpyEnabledMsg(String spyEnabledMsg) {
		this.spyEnabledMsg = spyEnabledMsg;
	}

	public void setSpyDisabledMsg(String spyDisabledMsg) {
		this.spyDisabledMsg = spyDisabledMsg;
	}

	public void setGlobalEnabledMsg(String globalEnabledMsg) {
		this.globalEnabledMsg = globalEnabledMsg;
	}

	public void setGlobalDisabledMsg(String globalDisabledMsg) {
		this.globalDisabledMsg = globalDisabledMsg;
	}

}
