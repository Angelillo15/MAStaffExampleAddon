package es.angelillo15.mast.example.addon;

import es.angelillo15.mast.api.addons.MAStaffAddon;

public class MastExampleAddon extends MAStaffAddon {
    /**
     * Called when the addon is enabled.
     */
    @Override
    public void onEnable() {
        getLogger().info("MastExampleAddon enabled!");
        loadConfig();
    }

    /**
     * Called when the addon is disabled.
     */
    @Override
    public void onDisable() {
        getMastaffInstance().getLogger().info("MastExampleAddon disabled!");
    }

    public void reloadConfig() {
        loadConfig();
    }
}
