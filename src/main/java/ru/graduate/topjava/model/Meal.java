package ru.graduate.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal extends AbstractNamedEntity {
  private LocalDateTime dateTime;
  private int price;
  private Cafe cafe;

  public Meal() {
  }

/*    public Meal(LocalDateTime dateTime, String description, int price) {
        this(null, dateTime, description, price);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int price) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.price = price;
    }*/

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
            "id=" + id +
            ", dateTime=" + dateTime +
            ", price=" + price +
            '}';
  }
}