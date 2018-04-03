package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface MealService {
  Meal get(int id, int userId) throws NotFoundException;
  void delete(int id, int userId) throws NotFoundException;
  List<Meal> getAll(int userId);
  Meal update(Meal meal, int userId) throws NotFoundException;
  Meal create(Meal meal, int userId);
}