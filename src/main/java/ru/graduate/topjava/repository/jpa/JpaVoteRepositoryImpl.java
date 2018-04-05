package ru.graduate.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.repository.UserRepository;
import ru.graduate.topjava.repository.VoteRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
//@Transactional(readOnly = true)
public class JpaVoteRepositoryImpl implements VoteRepository {

/*
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
*/

  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public Vote save(Vote vote) {
    if (vote.isNew()) {
      em.persist(vote);
      return vote;
    } else {
      return em.merge(vote);
    }
  }

  @Override
  public Vote get(int id) {
//    return em.find(Vote.class, id);
    TypedQuery query = em.createQuery("SELECT e FROM Vote e LEFT JOIN FETCH e.cafe LEFT JOIN FETCH e.user", Vote.class);
    List<Vote> resultList = query.getResultList();
    Vote vote = resultList.get(0);
//        System.out.println(vote.getMeals());
    return vote;
  }

  @Override
  @Transactional
  public boolean delete(int id) {

/*      Vote ref = em.getReference(Vote.class, id);
        em.remove(ref);

        Query query = em.createQuery("DELETE FROM Vote u WHERE u.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
*/
    return em.createNamedQuery(null)
            .setParameter("id", id)
            .executeUpdate() != 0;
  }



  @Override
  public List<Vote> getAll() {
    return em.createNamedQuery(null, Vote.class).getResultList();
  }

  //    @Transactional(readOnly = true)
  public Vote getWithMeals2(int id) {
/*        List<Vote> users = em.createNamedQuery(Vote.ALL_WITH_Meal, Vote.class)
                .setParameter("userId", id)
                .getResultList();

        return users.size() > 0 ? users.get(0) : null;*/

    TypedQuery query = em.createQuery("SELECT e FROM Vote e ", Vote.class);
//        TypedQuery query = em.createQuery("SELECT e FROM Vote e LEFT JOIN FETCH e.meals", Vote.class);
    List<Vote> resultList = query.getResultList();
    Vote vote = resultList.get(0);
//        System.out.println(vote.getMeals());
    return vote;
  }

  @Transactional(readOnly = true)
  public Vote getWithMeals(int id) {
    Vote withMeals2 = getWithMeals2(id);
//    System.out.println(null);
    return withMeals2;
  }
}
