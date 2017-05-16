package com.greenfox.dszalay.tamafoxy.Models;

import java.util.ArrayList;

public class ActionHistory {

  ArrayList<String> history;

  public ActionHistory() {
    history = new ArrayList<>();
  }

  public void addHistoryEntry(int index, String entry) {
    this.history.add(index, entry);
  }

  public ArrayList<String> getHistory() {
    return this.history;
  }

  public int sizeOfHistory() {
    return this.history.size();
  }

  public String getEntry(int index) {
    return history.get(index);
  }
}
