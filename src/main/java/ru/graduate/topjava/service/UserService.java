package ru.graduate.topjava.service;

import ru.graduate.topjava.model.User;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

  User create(User user);

  void delete(int id) throws NotFoundException;

  User get(int id) throws NotFoundException;

  User getByEmail(String email) throws NotFoundException;

  void update(User user);

  List<User> getAll();

  User getWithMeals(int id);
}