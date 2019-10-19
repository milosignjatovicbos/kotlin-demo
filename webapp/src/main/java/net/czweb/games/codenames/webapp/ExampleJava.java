package net.czweb.games.codenames.webapp;

import net.czweb.games.codenames.model.Card;

public class ExampleJava {
  private Card card;

  public ExampleJava(Card card) {
    this.card = card;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }
}
