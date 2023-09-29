package com.nookure.mast.addon.example.listener;

import com.google.inject.Inject;
import com.nookure.mast.addon.example.event.ExampleCommandExecuteEvent;
import com.nookure.mast.addon.example.event.ExampleEvent;
import com.nookure.mast.api.addons.annotations.AddonLogger;
import com.nookure.mast.api.event.MastSubscribe;
import es.angelillo15.mast.api.ILogger;

public class ExampleListener {
  @Inject
  @AddonLogger
  private ILogger logger;

  @MastSubscribe
  public void onExampleEvent(ExampleEvent event) {
    logger.info("Example event text: " + event.getText());
  }

  @MastSubscribe
  public void onExampleCommand(ExampleCommandExecuteEvent event) {
    if (event.getArgs().length == 0) {
      event.getSender().sendMessage("Provide an argument!, anything!");
      event.setCancelled(true);
      return;
    }

    if (event.getArgs()[0].equalsIgnoreCase("foo")) {
      event.getSender().sendMessage("bar");
      event.setCancelled(true);
      return;
    }
  }
}
