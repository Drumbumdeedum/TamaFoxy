package com.greenfox.dszalay.tamafoxy.Models;

import java.util.ArrayList;

public class TrickList {

  ArrayList<Trick> trickList;

  public TrickList() {
    trickList = new ArrayList<>();
  }

  public void addTrick(Trick trick) {
    this.trickList.add(trick);
  }

  public int getTrickListSize() {
    return this.trickList.size();
  }

  public ArrayList<Trick> getTrickList() {
    return this.trickList;
  }

  public void removeTrick(int index) {
    this.trickList.remove(index);
  }
}
