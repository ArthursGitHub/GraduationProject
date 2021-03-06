package ru.graduate.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.repository.MealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepositoryImpl implements MealRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Meal get(int id, int cafeId) {
    List<Meal> meals = em.createNamedQuery(Meal.GET_BY_CAFE, Meal.class)
            .setParameter("mealId", id)
            .setParameter("cafeId", cafeId)
            .getResultList();
    return DataAccessUtils.singleResult(meals);
  }

  @Override
  @Transactional
  public Meal save(Meal meal, int cafeId, LocalDate date) {
    if (!meal.isNew() && get(meal.getId(), cafeId) == null) {
      return null;
    }
    meal.setCafe(em.getReference(Cafe.class, cafeId));
    meal.setDate(date);
    if (meal.isNew()) {
      em.persist(meal);
      return meal;
    } else {
      return em.merge(meal);
    }
  }

  @Override
  public List<Meal> getAll(int cafeId, LocalDate date) {
    return em.createNamedQuery(Meal.GET_ALL_BY_CAFE_BY_DATE, Meal.class)
            .setParameter("cafeId", cafeId)
            .setParameter("date", date)
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