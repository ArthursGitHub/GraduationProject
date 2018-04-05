package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface VoteService {

  Vote create(Vote user);

  void delete(int id) throws NotFoundException;

  Vote get(int id) throws NotFoundException;

  Vote getByEmail(String email) throws NotFoundException;

  void update(Vote user);

  List<Vote> getAll();

  Vote getWithMeals(int id);
}