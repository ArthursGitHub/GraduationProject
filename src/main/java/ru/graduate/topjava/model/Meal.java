package ru.graduate.topjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NamedQueries({
        @NamedQuery(name = Meal.GET_BY_CAFE, query = "SELECT m FROM Meal m LEFT JOIN FETCH m.cafe WHERE m.id=:mealId AND m.cafe.id=:cafeId"),
        @NamedQuery(name = Meal.GET_ALL_BY_CAFE_BY_DATE, query = "SELECT m FROM Meal m WHERE m.cafe.id=:cafeId AND m.dateTime=:date"),
        @NamedQuery(name = Meal.DELETE,  query = "DELETE   FROM Meal m WHERE m.id=:mealId AND m.cafe.id=:cafeId"),
})
@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {
  public static final String GET_BY_CAFE = "Meal.getByCafe";
  public static final String GET_ALL_BY_CAFE_BY_DATE = "Meal.getAllByCafeByDate";
  public static final String DELETE = "Meal.delete";

  @Column(name = "date_time")
  private LocalDate dateTime;
  private int price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cafe_id", nullable = false)
  @NotNull
  private Cafe cafe;

  public Meal() {
  }

  public LocalDate getDateTime() {
    return dateTime;
  }
  public void setDateTime(LocalDate dateTime) {
    this.dateTime = dateTime;
  }

  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }

  public Cafe getCafe() {
    return cafe;
  }
  public void setCafe(Cafe cafe) {
    this.cafe = cafe;
  }

  @Override
  public String toString() {
    return "Meal{" +
            "\nid = " + id +
            "\nname = " + name +
            "\nprice = " + price +
            "\ndateTime = " + dateTime +
//            "\ncafe = " + getCafe() +
            "\n}";
  }
}
