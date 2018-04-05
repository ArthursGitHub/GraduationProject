package ru.graduate.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.repository.CafeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaCafeRepositoryImpl implements CafeRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public Cafe save(Cafe meal, int userId) {
    if (!meal.isNew() && get(meal.getId()) == null) {
      return null;
    }
//    meal.setUser(em.getReference(User.class, userId));
    if (meal.isNew()) {
      em.persist(meal);
      return meal;
    } else {
      return em.merge(meal);
    }
  }

  @Override
  @Transactional
  public boolean delete(int id, int userId) {
/*    return em.createNamedQuery(Cafe.DELETE)
            .setParameter("id", id)
            .setParameter("userId", userId)
            .executeUpdate() != 0;*/
    return true;
  }

  @Override
  public Cafe get(int id) {
    Cafe cafe = em.find(Cafe.class, id);
    return cafe;
  }

  @Override
  public List<Cafe> getAll(int userId) {
/*    return em.createNamedQuery(Cafe.ALL_SORTED, Cafe.class)
            .setParameter("userId", userId)
            .getResultList();*/
    return null;
  }
}