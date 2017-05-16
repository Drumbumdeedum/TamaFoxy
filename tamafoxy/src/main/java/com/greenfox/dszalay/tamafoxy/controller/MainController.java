package com.greenfox.dszalay.tamafoxy.controller;

import com.greenfox.dszalay.tamafoxy.Models.Fox;
import com.greenfox.dszalay.tamafoxy.Models.Trick;
import com.greenfox.dszalay.tamafoxy.Models.TrickList;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @Autowired
  Fox foxy;

  @Autowired
  TrickList allTricks;

  int fillTricks = 0;

  @RequestMapping("/")
  public String noIndex(Model model) {
    model.addAttribute("foxy",foxy);
    return "index";
  }

  @RequestMapping("/index.html")
  public String index(Model model) {
    model.addAttribute("foxy",foxy);
    return "index";
  }

  @RequestMapping("/setimage")
  public String setImage(Model model, String image) {
    foxy.setImage(image);
    model.addAttribute("foxy", foxy);
    return "index";
  }

  @RequestMapping("/nutritioncenter.html")
  public String nutritionCenter(Model model) {
    model.addAttribute("foxy",foxy);
    return "nutritioncenter";
  }

  @RequestMapping("/setnutrition")
  public String setnutrition(String food, String drink, Model model) {

    if (food.equals("")) {
      food = "\'add favourite food here\'";
    }
    if (drink.equals("")) {
      drink = "\'add favourite drink here\'";
    }

    if (!foxy.getFavouriteFood().toLowerCase().equals(food.toLowerCase()) && !food.equals("")) {
      foxy.addToActionHistory(LocalDate.now().toString() + " " + foxy.getName() + "\'s favourite food has been changed from: " + foxy.getFavouriteFood() + " to: " + food + ".");
    }
    if (!foxy.getFavouriteDrink().toLowerCase().equals(drink.toLowerCase()) && !drink.equals("")) {
      foxy.addToActionHistory(LocalDate.now().toString() + " " + foxy.getName() +  "\'s favourite drink has been changed from: " + foxy.getFavouriteDrink() + " to: " + drink + ".");
    }

    foxy.setFavouriteDrink(drink);
    foxy.setFavouriteFood(food);

    model.addAttribute("foxy", foxy);
    return "nutritioncenter";
  }

  @RequestMapping("/trickcenter.html")
  public String trickCenter(Model model) {

    if (fillTricks == 0) {
      allTricks.addTrick(new Trick("play the drums", "images/nobackgroundfoxdrums.png"));
      allTricks.addTrick(new Trick("play the guitar", "images/nobackgroundfoxguitar.png"));
      allTricks.addTrick(new Trick("be a gangsta", "images/nobackgroundfoxpimp.png"));
      allTricks.addTrick(new Trick("code in Java", "images/nobackgroundfox.png"));
      fillTricks++;
    }

    model.addAttribute("allTricks", allTricks);
    model.addAttribute("foxy",foxy);
    return "trickcenter";
  }

  @RequestMapping("/settrick")
  public String setTrick(String trick, Model model) {

    String trickImage = "";
    int trickId = 0;

    for (int i=0; i < allTricks.getTrickListSize(); i++) {
      if (allTricks.getTrickList().get(i).getTrickName().equals(trick)) {
        trickId = i;
      }
    }

    if (trick.equals("play the drums")) {
      trickImage = "images/nobackgroundfoxdrums.png";
    }
    if (trick.equals("play the guitar")) {
      trickImage = "images/nobackgroundfoxguitar.png";
    }
    if (trick.equals("be a gangsta")) {
      trickImage = "images/nobackgroundfoxpimp.png";
    }
    if (trick.equals("code in Java")) {
      trickImage = "images/nobackgroundfox.png";
    }

    if (!foxy.knowsTrick(trick) && !trick.equals("all tricks learned")) {
      foxy.addTrick(trick, trickImage);
      foxy.addToActionHistory(LocalDate.now().toString() + " " + foxy.getName() + " learned to " + trick + ".");
      allTricks.removeTrick(trickId);
    }

    if (allTricks.getTrickListSize() == 0) {
      allTricks.addTrick(new Trick("all tricks learned", "none"));
    }

    model.addAttribute("allTricks", allTricks);
    model.addAttribute("foxy", foxy);
    return "trickcenter";
  }

  @RequestMapping("/actionhistory.html")
  public String actionHistory(Model model) {
    ArrayList<String> lastSevenEnries = new ArrayList<>();

    if(!foxy.actionHistoryEmpty()) {
      if(foxy.getActionHistory().size() < 8) {
        for (int i=0; i < foxy.getActionHistory().size(); i++) {
          lastSevenEnries.add(foxy.getHistoryEntry(foxy.getActionHistory().size()-1-i));
        }
      } else if (foxy.getActionHistory().size() >= 8) {
        for (int i=0; i < 8; i++) {
          lastSevenEnries.add(foxy.getHistoryEntry(foxy.getActionHistory().size()-1-i));
        }
      }
    }

    model.addAttribute("entires", lastSevenEnries);
    model.addAttribute("foxy", foxy);
    return "actionhistory";
  }
}
