package ru.graduate.topjava.repository;

import ru.graduate.topjava.model.User;

import java.util.List;

public interface UserRepository {
  User get(int id);       // null if not found
  User save(User user);
  List<User> getAll();
  boolean delete(int id); // false if not found
}