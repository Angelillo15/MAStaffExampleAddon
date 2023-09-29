package com.nookure.mast.addon.example.event;

import com.nookure.mast.api.cmd.sender.CommandSender;
import com.nookure.mast.api.event.Cancelable;
import com.nookure.mast.api.event.Event;

public class ExampleCommandExecuteEvent extends Event implements Cancelable {
  private final String command;
  private final String[] args;
  private final CommandSender sender;
  private boolean cancelled;

  public ExampleCommandExecuteEvent(String command, String[] args, CommandSender sender) {
    this.command = command;
    this.args = args;
    this.sender = sender;
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean b) {
    this.cancelled = b;
  }

  public String getCommand() {
    return command;
  }

  public String[] getArgs() {
    return args;
  }

  public CommandSender getSender() {
    return sender;
  }
}
