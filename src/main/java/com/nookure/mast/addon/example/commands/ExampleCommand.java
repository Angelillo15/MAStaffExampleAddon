package com.nookure.mast.addon.example.commands;

import com.google.inject.Inject;
import com.nookure.mast.addon.example.event.ExampleCommandExecuteEvent;
import com.nookure.mast.api.cmd.Command;
import com.nookure.mast.api.cmd.CommandData;
import com.nookure.mast.api.cmd.sender.CommandSender;
import com.nookure.mast.api.event.EventManager;
import org.jetbrains.annotations.NotNull;

@CommandData(
    name = "example",
    description = "Example command",
    aliases = {"ex"},
    permission = "mast.example",
    usage = "/example"
)
public class ExampleCommand extends Command {
  @Inject
  private EventManager eventManager;

  @Override
  public void onCommand(@NotNull CommandSender commandSender, @NotNull String label, @NotNull String[] args) {
    ExampleCommandExecuteEvent event = new ExampleCommandExecuteEvent(label, args, commandSender);
    eventManager.fireEvent(event);

    if (event.isCancelled()) {
      return;
    }

    commandSender.sendMessage("Example command with arguments: " + String.join(" ", args));
  }
}
