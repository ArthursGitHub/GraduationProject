package ru.graduate.topjava.repository;


import ru.graduate.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository {
  // null if updated meal do not belong to userId
  Meal save(Meal meal, int userId);

  // false if meal do not belong to userId
  boolean delete(int id, int userId);

  // null if meal do not belong to userId
  Meal get(int id);

  // ORDERED dateTime desc
  List<Meal> getAll(int userId);

}
