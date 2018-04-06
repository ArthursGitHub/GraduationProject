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
  public Cafe get(int id) {
    return em.find(Cafe.class, id);
  }

  @Override
  @Transactional
  public Cafe save(Cafe cafe) {
    if (cafe.isNew()) {
      em.persist(cafe);
      return cafe;
    } else {
      return em.merge(cafe);
    }
  }

  @Override
  public List<Cafe> getAll() {
    return em.createNamedQuery(Cafe.ALL_SORTED, Cafe.class).getResultList();
  }

  @Override
  @Transactional
  public boolean delete(int id) {
    return em.createNamedQuery(Cafe.DELETE)
            .setParameter("id", id)
            .executeUpdate() != 0;
  }
}
