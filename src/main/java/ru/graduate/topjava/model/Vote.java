package ru.graduate.topjava.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Vote.GET_ALL_BY_DATE, query = "SELECT v FROM Vote v LEFT JOIN FETCH v.cafe WHERE v.dateTime Between ?1 and ?2"),
//        @NamedQuery(name = Vote.GET_BY_USER_BY_DATETIME, query = "SELECT v FROM Vote v LEFT JOIN FETCH v.cafe WHERE v.user.id=:userId AND v.dateTime=:dateTime"),
        @NamedQuery(name = Vote.GET_BY_USER_BY_DATE, query = "SELECT v FROM Vote v LEFT JOIN FETCH v.cafe WHERE v.user.id=:userId AND v.dateTime Between :dateTime1 and :dateTime2"),
        @NamedQuery(name = Vote.GET_BY_ID_BY_USER, query = "SELECT v FROM Vote v WHERE v.id=:voteId AND v.user.id=:userId"),
        @NamedQuery(name = Vote.DELETE, query = "DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userId AND v.dateTime Between :dateTime1 and :dateTime2"),
})
@Entity
public class Vote extends AbstractBaseEntity {
  public static final String GET_ALL_BY_DATE = "Vote.getAllByDate";
  //  public static final String GET_BY_USER_BY_DATETIME = "Vote.getByUserByDateTime";
  public static final String GET_BY_USER_BY_DATE = "Vote.getByUserByDate";
  public static final String GET_BY_ID_BY_USER = "Vote.getByIdByUser";
  public static final String DELETE = "Vote.delete";

  @Column(name = "date_time")
  private LocalDateTime dateTime;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="cafe_id")
  private Cafe cafe;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="user_id")
  private User user;

  public Vote() {
  }

  public Vote(Vote vote) {
    this(vote.getId(), vote.getUser(), vote.getCafe(), vote.dateTime);
  }

  public Vote(int id) {
    super(id);
  }

  public Vote(Integer id, User user, Cafe cafe, LocalDateTime date21) {
    this(id);
    setUser(user);
    setCafe(cafe);
  }

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
//            ", cafe=" + cafe +
//            ", user=" + user +
            ", dateTime=" + dateTime +
            '}';
  }
}
