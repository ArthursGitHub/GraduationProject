package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {
//  Vote get(Integer vote1Id, int id, LocalDateTime dateTime) throws NotFoundException;
  Vote get(Integer userId, LocalDate date) throws NotFoundException;
  Vote create(Vote user);
  void update(Vote user);
  List<Vote> getAll(LocalDate date);
  void delete(int id) throws NotFoundException;
}
