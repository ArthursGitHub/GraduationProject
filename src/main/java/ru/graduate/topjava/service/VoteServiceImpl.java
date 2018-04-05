package ru.graduate.topjava.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.repository.VoteRepository;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

import static ru.graduate.topjava.util.ValidationUtil.checkNotFound;
import static ru.graduate.topjava.util.ValidationUtil.checkNotFoundWithId;


@Service
public class VoteServiceImpl implements VoteService {

  private final VoteRepository repository;

  @Autowired
  public VoteServiceImpl(VoteRepository repository) {
    this.repository = repository;
  }

  @CacheEvict(value = "votes", allEntries = true)
  @Override
  public Vote create(Vote vote) {
    Assert.notNull(vote, "vote must not be null");
    return repository.save(vote);
  }

  @CacheEvict(value = "votes", allEntries = true)
  @Override
  public void delete(int id) throws NotFoundException {
    checkNotFoundWithId(repository.delete(id), id);
  }

  @Override
  public Vote get(int id) throws NotFoundException {
    return checkNotFoundWithId(repository.get(id), id);
  }

  @Override
  public Vote getByEmail(String email) throws NotFoundException {
    Assert.notNull(email, "email must not be null");
    return null;
  }

  @Cacheable("votes")
  @Override
  public List<Vote> getAll() {
    return repository.getAll();
  }

  @CacheEvict(value = "votes", allEntries = true)
  @Override
  public void update(Vote vote) {
    Assert.notNull(vote, "vote must not be null");
    checkNotFoundWithId(repository.save(vote), vote.getId());
  }

  @Override
  public Vote getWithMeals(int id) {
//    Vote withMeals = repository.getWithMeals(id);
//        System.out.println(withMeals.getMeals());
    return null;
  }
}