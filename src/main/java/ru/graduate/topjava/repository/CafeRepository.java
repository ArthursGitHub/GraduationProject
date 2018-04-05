package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.Cafe;

import java.util.List;

public interface CafeRepository {
  Cafe save(Cafe cafe);
  boolean delete(int id);
  Cafe get(int id);
  List<Cafe> getAll();
}
