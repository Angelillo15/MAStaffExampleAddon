package com.nookure.mast.addon.example.event;

import com.nookure.mast.api.event.Event;

public class ExampleEvent extends Event {
  private final String text;

  public ExampleEvent(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
