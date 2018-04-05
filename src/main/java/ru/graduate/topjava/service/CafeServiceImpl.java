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
  public void delete(int id) {
    checkNotFoundWithId(repository.delete(id), id);
  }

  @Override
  public List<Cafe> getAll() {
    return repository.getAll();
  }

  @Override
  public Cafe update(Cafe cafe) {
    return checkNotFoundWithId(repository.save(cafe), cafe.getId());
  }

  @Override
  public Cafe create(Cafe cafe) {
    Assert.notNull(cafe, "cafe must not be null");
    return repository.save(cafe);
  }
}
