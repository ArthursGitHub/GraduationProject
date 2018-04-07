package ru.graduate.topjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NamedQueries({
        @NamedQuery(name = Meal.BY_CAFE, query = "SELECT m FROM Meal m WHERE m.id=:mealId AND m.cafe.id=:cafeId"),
        @NamedQuery(name = Meal.GET_ALL, query = "SELECT m FROM Meal m WHERE m.cafe.id=:cafeId"),
        @NamedQuery(name = Meal.DELETE,  query = "DELETE   FROM Meal m WHERE m.id=:mealId AND m.cafe.id=:cafeId"),
})
@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {
  public static final String BY_CAFE = "Meal.getByCafe";
  public static final String GET_ALL = "Meal.getAll";
  public static final String DELETE = "Meal.delete";

  @Column(name = "date_time")
  private LocalDateTime dateTime;
  private int price;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "cafe_id", nullable = false)
  @NotNull
  private Cafe cafe;

  public Meal() {
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }
  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public LocalDate getDate() {
    return dateTime.toLocalDate();
  }
  public LocalTime getTime() {
    return dateTime.toLocalTime();
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
            "\ncafe = " + getCafe() +
            "\n}";
  }
}
