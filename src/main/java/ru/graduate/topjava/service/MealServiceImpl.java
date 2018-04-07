package ru.graduate.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.repository.MealRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.graduate.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

  private final MealRepository repository;

  @Autowired
  public MealServiceImpl(MealRepository repository) {
    this.repository = repository;
  }

  @Override
  public Meal get(int id, int cafeId) {
    return checkNotFoundWithId(repository.get(id, cafeId), id);
  }

  @Override
  public Meal create(Meal meal, int cafeId, LocalDate date) {
    Assert.notNull(meal, "meal must not be null");
    return repository.save(meal, cafeId, date);
  }

  @Override
  public Meal update(Meal meal, int cafeId, LocalDate date) {
    return checkNotFoundWithId(repository.save(meal, cafeId, date), meal.getId());
  }

  @Override
  public List<Meal> getAll(int cafeId, LocalDate date) {
    return repository.getAll(cafeId, date);
  }

  @Override
  public void delete(int id, int cafeId) {
    checkNotFoundWithId(repository.delete(id, cafeId), id);
  }
}
