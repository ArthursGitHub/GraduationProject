package ru.graduate.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.repository.MealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepositoryImpl implements MealRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public Meal save(Meal meal, int userId) {
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
/*    return em.createNamedQuery(Meal.DELETE)
            .setParameter("id", id)
            .setParameter("userId", userId)
            .executeUpdate() != 0;*/
    return true;
  }

  @Override
  public Meal get(int id) {
    Meal meal = em.find(Meal.class, id);
    return meal;
  }

  @Override
  public List<Meal> getAll(int userId) {
/*    return em.createNamedQuery(Meal.ALL_SORTED, Meal.class)
            .setParameter("userId", userId)
            .getResultList();*/
    return null;
  }
}