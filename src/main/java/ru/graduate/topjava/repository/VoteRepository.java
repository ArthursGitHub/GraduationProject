package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.Vote;

import java.util.List;

public interface VoteRepository {
  // null if updated meal do not belong to userId
  Vote save(Vote meal);

  // false if meal do not belong to userId
  boolean delete(int id);

  // null if meal do not belong to userId
  Vote get(int id);

  // ORDERED dateTime desc
  List<Vote> getAll();

}
