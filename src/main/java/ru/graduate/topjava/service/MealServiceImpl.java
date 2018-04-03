package ru.graduate.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.repository.MealRepository;

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
  public Meal get(int id, int userId) {
    return checkNotFoundWithId(repository.get(id, userId), id);
  }

  @Override
  public void delete(int id, int userId) {
    checkNotFoundWithId(repository.delete(id, userId), id);
  }

  @Override
  public List<Meal> getAll(int userId) {
    return repository.getAll(userId);
  }

  @Override
  public Meal update(Meal meal, int userId) {
    return checkNotFoundWithId(repository.save(meal, userId), meal.getId());
  }

  @Override
  public Meal create(Meal meal, int userId) {
    Assert.notNull(meal, "meal must not be null");
    return repository.save(meal, userId);
  }
}