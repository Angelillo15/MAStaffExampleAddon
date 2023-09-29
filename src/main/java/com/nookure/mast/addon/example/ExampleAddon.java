package com.nookure.mast.addon.example;

import com.google.inject.Inject;
import com.nookure.mast.addon.example.commands.ExampleCommand;
import com.nookure.mast.addon.example.event.ExampleEvent;
import com.nookure.mast.addon.example.listener.ExampleListener;
import com.nookure.mast.api.addons.AddonActions;
import com.nookure.mast.api.addons.annotations.Addon;
import com.nookure.mast.api.addons.annotations.AddonDataFolder;
import com.nookure.mast.api.addons.annotations.AddonLogger;
import com.nookure.mast.api.addons.config.AddonConfig;
import com.nookure.mast.api.event.EventManager;
import es.angelillo15.mast.api.ILogger;

import java.io.File;
import java.util.Objects;

@Addon(
    // Addon name/id (must be unique) (required)
    name = "ExampleAddon",
    // Addon version (required)
    version = "${version}",
    // Addon author (required)
    author = "Nookure",
    // Addon description (optional)
    description = "Example addon for MAStaff",
    // Addon platform (optional) (default: COMMON)
    platform = Addon.AddonPlatform.COMMON,
    // Load addon on scan (optional) (default: true)
    loadOnScan = true,
    // Addon listeners (optional)
    listeners = {
        ExampleListener.class
    },
    // Addon commands (optional)
    commands = {
        ExampleCommand.class
    }
)
public class ExampleAddon implements AddonActions {
  @Inject
  private AddonConfig config;
  @Inject
  private EventManager eventManager;
  @Inject
  @AddonLogger
  private ILogger logger;
  @Inject
  @AddonDataFolder
  private File addonDataFolder;

  @Override
  public void onEnable() {
    logger.info("ExampleAddon enabled!");
    logger.info("ExampleAddon config: " + Objects.requireNonNull(
        config.getDefaultConfig()
    ).getConfig().getString("Config.example"));
    logger.info("ExampleAddon plugin data folder: " + addonDataFolder.getAbsolutePath());
    eventManager.fireEvent(new ExampleEvent("foobar"));
  }

  @Override
  public void onDisable() {
    logger.info("ExampleAddon disabled!");
  }

  @Override
  public void onReload() {
    logger.info("ExampleAddon reloaded!");
  }
}
