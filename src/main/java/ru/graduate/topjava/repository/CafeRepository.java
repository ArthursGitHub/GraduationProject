package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.Cafe;

import java.util.List;

public interface CafeRepository {
  Cafe get(int id);       // null if not found
  Cafe save(Cafe cafe);
  List<Cafe> getAll();
  boolean delete(int id); // false if not found
}
