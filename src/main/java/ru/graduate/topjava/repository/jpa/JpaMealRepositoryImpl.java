package ru.graduate.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.Cafe;
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
  public Meal get(int id, int cafeId) {
    List<Meal> meals = em.createNamedQuery(Meal.BY_CAFE, Meal.class)
            .setParameter("mealId", id)
            .setParameter("cafeId", cafeId)
            .getResultList();
    Meal meal = DataAccessUtils.singleResult(meals);
    return meal;
  }

  @Override
  @Transactional
  public Meal save(Meal meal, int cafeId) {
    if (!meal.isNew() && get(meal.getId(), cafeId) == null) {
      return null;
    }
    meal.setCafe(em.getReference(Cafe.class, cafeId));
    if (meal.isNew()) {
      em.persist(meal);
      return meal;
    } else {
      return em.merge(meal);
    }
  }

  @Override
  public List<Meal> getAll(int cafeId) {
    return em.createNamedQuery(Meal.GET_ALL, Meal.class)
            .setParameter("cafeId", cafeId)
            .getResultList();
  }

  @Override
  @Transactional
  public boolean delete(int id, int cafeId) {
    return em.createNamedQuery(Meal.DELETE)
            .setParameter("mealId", id)
            .setParameter("cafeId", cafeId)
            .executeUpdate() != 0;
  }
}