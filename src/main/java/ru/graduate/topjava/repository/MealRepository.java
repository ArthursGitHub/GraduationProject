package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.Meal;

import java.util.List;

public interface MealRepository {
  Meal get(int id, int cafeId);       // null if meal do not belong to cafeId
  Meal save(Meal meal, int cafeId);   // null if updated meal do not belong to cafeId
  List<Meal> getAll(int cafeId);      // ORDERED cafeId, dateTime
  boolean delete(int id, int cafeId); // false if meal do not belong to cafeId
}
