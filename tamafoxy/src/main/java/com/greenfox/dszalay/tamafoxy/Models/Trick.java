package com.greenfox.dszalay.tamafoxy.Models;

public class Trick {

  String trickName;
  String image;

  public Trick(String trickName, String image) {
    this.trickName = trickName;
    this.image = image;
  }

  public String getTrickName() {
    return this.trickName;
  }

  public String getImageName() {
    return this.image;
  }
}
