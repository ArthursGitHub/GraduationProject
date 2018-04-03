package ru.graduate.topjava.model;

import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity {
  private LocalDateTime dateTime;
  private Cafe cafe;
  private User user;


  public LocalDateTime getDateTime() {
    return dateTime;
  }
  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Cafe getCafe() {
    return cafe;
  }
  public void setCafe(Cafe cafe) {
    this.cafe = cafe;
  }

  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
}
