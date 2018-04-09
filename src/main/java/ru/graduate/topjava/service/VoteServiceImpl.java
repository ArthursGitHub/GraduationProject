package ru.graduate.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.repository.VoteRepository;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.graduate.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteServiceImpl implements VoteService {

  private final VoteRepository repository;

  @Autowired
  public VoteServiceImpl(VoteRepository repository) {
    this.repository = repository;
  }

/*  @Override
  public Vote get(Integer id, int userId, LocalDateTime dateTime) throws NotFoundException {
    return checkNotFoundWithId(repository.get(id, userId, dateTime), id);
  }*/

  @Override
  public Vote get(Integer userId, LocalDate date) throws NotFoundException {
    return repository.get(userId, date);
  }

  @Override
  public Vote create(Vote vote, Integer userId, LocalDateTime dateTime, Integer cafeId) {
    Assert.notNull(vote, "vote must not be null");
    return repository.save(vote, userId, dateTime, cafeId);
  }

  @Override
  public void update(Vote vote, Integer userId, LocalDateTime dateTime, Integer cafeId) {
    Assert.notNull(vote, "vote must not be null");
    checkNotFoundWithId(repository.save(vote, userId, dateTime, cafeId), vote.getId());
  }

  @Override
  public List<Vote> getAll(LocalDate date) {
    return repository.getAll(date);
  }

  @Override
  public void delete(int id) throws NotFoundException {
    checkNotFoundWithId(repository.delete(id), id);
  }
}
