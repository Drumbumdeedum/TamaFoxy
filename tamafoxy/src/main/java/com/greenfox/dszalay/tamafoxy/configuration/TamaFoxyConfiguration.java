package com.greenfox.dszalay.tamafoxy.configuration;

import com.greenfox.dszalay.tamafoxy.Models.Fox;
import com.greenfox.dszalay.tamafoxy.Models.TrickList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TamaFoxyConfiguration {

  @Bean
  public Fox getFox() {
    return new Fox();
  }

  @Bean
  public TrickList getTrickList() {
    return new TrickList();
  }
}
