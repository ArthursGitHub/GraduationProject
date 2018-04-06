package ru.graduate.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.User;
import ru.graduate.topjava.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepositoryImpl implements UserRepository {
  @PersistenceContext
  private EntityManager em;

  @Override
  public User get(int id) {
    return em.find(User.class, id);
  }

  @Override
  @Transactional
  public User save(User user) {
    if (user.isNew()) {
      em.persist(user);
      return user;
    } else {
      return em.merge(user);
    }
  }

  @Override
  public List<User> getAll() {
    return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
  }

  @Override
  @Transactional
  public boolean delete(int id) {
    return em.createNamedQuery(User.DELETE)
            .setParameter("id", id)
            .executeUpdate() != 0;
  }
}
