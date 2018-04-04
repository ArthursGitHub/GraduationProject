package ru.graduate.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.repository.CafeRepository;

import java.util.List;

import static ru.graduate.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CafeServiceImpl implements CafeService {

  private final CafeRepository repository;

  @Autowired
  public CafeServiceImpl(CafeRepository repository) {
    this.repository = repository;
  }

  @Override
  public Cafe get(int id) {
    return checkNotFoundWithId(repository.get(id), id);
  }

  @Override
  public void delete(int id, int userId) {
    checkNotFoundWithId(repository.delete(id, userId), id);
  }

  @Override
  public List<Cafe> getAll(int userId) {
    return repository.getAll(userId);
  }

  @Override
  public Cafe update(Cafe meal, int userId) {
    return checkNotFoundWithId(repository.save(meal, userId), meal.getId());
  }

  @Override
  public Cafe create(Cafe meal, int userId) {
    Assert.notNull(meal, "meal must not be null");
    return repository.save(meal, userId);
  }
}