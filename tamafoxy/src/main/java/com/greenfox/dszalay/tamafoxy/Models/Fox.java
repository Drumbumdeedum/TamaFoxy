package com.greenfox.dszalay.tamafoxy.Models;

import java.util.ArrayList;

public class Fox {

  String name, favouriteFood, favouriteDrink, image;
  TrickList trickList;
  ActionHistory actionHistory;

  public Fox() {
    image = "images/nobackgroundfox.png";
    name = "Foxy Cent";
    favouriteFood = "Hamburgers";
    favouriteDrink = "Mango IceTea";
    trickList = new TrickList();
    actionHistory = new ActionHistory();
  }

  public String getName() {
    return name;
  }

  public String getFavouriteDrink() {
    return favouriteDrink;
  }

  public void setFavouriteDrink(String favouriteDrink) {
    this.favouriteDrink = favouriteDrink;
  }

  public String getFavouriteFood() {
    return favouriteFood;
  }

  public void setFavouriteFood(String favouriteFood) {
    this.favouriteFood = favouriteFood;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ArrayList<Trick> getFoxyTricks() {
    return this.trickList.getTrickList();
  }

  public int getNumberOfTricks() {
    return this.trickList.getTrickListSize();
  }

  public String getTrickName() {
    return this.getTrickName();
  }

  public void addTrick(String trick, String image) {
    this.trickList.addTrick(new Trick(trick, image));
  }

  public boolean knowsTrick(String trick) {
    boolean knowsTrick = false;

    for (int i=0; i < this.getNumberOfTricks(); i++) {
      if (this.getFoxyTricks().get(i).getTrickName().equals(trick)) {
        knowsTrick = true;
      }
    }

    return knowsTrick;
  }

  public void addToActionHistory(String entry) {
    this.actionHistory.addHistoryEntry(0, entry);
  }

  public String getHistoryEntry(int index) {
    return this.actionHistory.getEntry(index);
  }

  public ArrayList<String> getActionHistory() {
    return this.actionHistory.getHistory();
  }

  public boolean actionHistoryEmpty() {
    boolean status = true;

    if (this.actionHistory.sizeOfHistory() == 0) {
      status = true;
    } else if (this.actionHistory.sizeOfHistory() > 0) {
      status = false;
    }

    return status;
  }
}
