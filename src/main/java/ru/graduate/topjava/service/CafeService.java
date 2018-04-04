package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface CafeService {
  //  Cafe get(int id, int userId) throws NotFoundException;
  Cafe get(int id) throws NotFoundException;
  void delete(int id, int userId) throws NotFoundException;
  List<Cafe> getAll(int userId);
  Cafe update(Cafe meal, int userId) throws NotFoundException;
  Cafe create(Cafe meal, int userId);
}