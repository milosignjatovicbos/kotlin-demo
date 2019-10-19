package no.dossier.app.kotlindemo.backend;

import no.dossier.app.kotlindemo.model.User;

public class ExampleJavaWrapper {
  private User user;

  public ExampleJavaWrapper(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
