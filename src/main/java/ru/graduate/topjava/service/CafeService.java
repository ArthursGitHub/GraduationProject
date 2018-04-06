package ru.graduate.topjava.service;

import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface CafeService {
  Cafe get(int id) throws NotFoundException;
  void delete(int id) throws NotFoundException;
  List<Cafe> getAll();
  Cafe update(Cafe cafe);
  Cafe create(Cafe cafe);
}