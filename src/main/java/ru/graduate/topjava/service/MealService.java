package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface MealService {
  Meal get(int id, int cafeId) throws NotFoundException;
  Meal create(Meal meal, int cafeId);
  Meal update(Meal meal, int cafeId) throws NotFoundException;
  List<Meal> getAll(int cafeId);
  void delete(int id, int cafeId) throws NotFoundException;
}
