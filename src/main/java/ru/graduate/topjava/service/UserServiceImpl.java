package ru.graduate.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduate.topjava.model.User;
import ru.graduate.topjava.repository.UserRepository;
import ru.graduate.topjava.util.exception.NotFoundException;
import java.util.List;
import static ru.graduate.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Autowired
  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User get(int id) throws NotFoundException {
    return checkNotFoundWithId(repository.get(id), id);
  }

  @Override
  public User create(User user) {
    Assert.notNull(user, "user must not be null");
    return repository.save(user);
  }

  @Override
  public void update(User user) {
    Assert.notNull(user, "user must not be null");
    checkNotFoundWithId(repository.save(user), user.getId());
  }

  @Override
  public List<User> getAll() {
    return repository.getAll();
  }

  @Override
  public void delete(int id) throws NotFoundException {
    checkNotFoundWithId(repository.delete(id), id);
  }
}