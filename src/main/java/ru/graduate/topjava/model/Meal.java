package ru.graduate.topjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NamedQueries({
        @NamedQuery(name = Meal.MEAL_WITH_CAFE, query = "SELECT m FROM Meal m LEFT JOIN FETCH m.cafe WHERE m.id=:mealId ")
})

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {

  public static final String MEAL_WITH_CAFE = "Meal.getMealWithCafe";
  @Column(name = "date_time")
  private LocalDateTime dateTime;
  private int price;

  @ManyToOne(fetch = FetchType.LAZY)
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
