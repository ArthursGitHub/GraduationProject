package ru.graduate.topjava.service;

import ru.graduate.topjava.model.User;
import ru.graduate.topjava.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
  User get(int id) throws NotFoundException;
  User create(User user);
  void update(User user);
  List<User> getAll();
  void delete(int id) throws NotFoundException;
}
