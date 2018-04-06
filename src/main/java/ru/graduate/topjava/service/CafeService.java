package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface CafeService {
  Cafe get(int id) throws NotFoundException;
  Cafe create(Cafe cafe);
  Cafe update(Cafe cafe);
  List<Cafe> getAll();
  void delete(int id) throws NotFoundException;
}