package ru.graduate.topjava.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vote extends AbstractBaseEntity {
  @Column(name = "date_time")
  private LocalDateTime dateTime;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="cafe_id")
  private Cafe cafe;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="user_id")
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

  @Override
  public String toString() {
    return "Vote{" +
            "id=" + id +
            ", cafe=" + cafe +
            ", user=" + user +
            ", dateTime=" + dateTime +
            '}';
  }
}
