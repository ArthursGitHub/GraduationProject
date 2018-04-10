package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VoteRepository {
//  Vote get(Integer integer, int id, LocalDateTime dateTime); // null if vote do not belong to userId
  Vote get(Integer id, LocalDate date); // null if vote do not belong to userId
  Vote save(Vote vote, Integer userId, LocalDateTime dateTime); // null if updated vote do not belong to userId
  List<Vote> getAll(LocalDate date);  // ORDERED dateTime desc
  boolean delete(int id, int userId, LocalDateTime dateTime); // false if vote do not belong to userId
}
