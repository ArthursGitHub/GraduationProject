package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.Cafe;

import java.util.List;

public interface CafeRepository {
  // null if updated meal do not belong to userId
  Cafe save(Cafe meal, int userId);

  // false if meal do not belong to userId
  boolean delete(int id, int userId);

  // null if meal do not belong to userId
  Cafe get(int id);

  // ORDERED dateTime desc
  List<Cafe> getAll(int userId);

}
