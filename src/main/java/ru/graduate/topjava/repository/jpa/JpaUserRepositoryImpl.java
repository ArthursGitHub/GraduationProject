package ru.graduate.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.User;
import ru.graduate.topjava.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
//@Transactional(readOnly = true)
public class JpaUserRepositoryImpl implements UserRepository {

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
  public User save(User user) {
    if (user.isNew()) {
      em.persist(user);
      return user;
    } else {
      return em.merge(user);
    }
  }

  @Override
  public User get(int id) {
    return em.find(User.class, id);
  }

  @Override
  @Transactional
  public boolean delete(int id) {

/*      User ref = em.getReference(User.class, id);
        em.remove(ref);

        Query query = em.createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
*/
    return em.createNamedQuery(null)
            .setParameter("id", id)
            .executeUpdate() != 0;
  }

  @Override
  public User getByEmail(String email) {
    List<User> users = em.createNamedQuery(null, User.class)
            .setParameter(1, email)
            .getResultList();
    return DataAccessUtils.singleResult(users);
  }

  @Override
  public List<User> getAll() {
    return em.createNamedQuery(null, User.class).getResultList();
  }

  //    @Transactional(readOnly = true)
  public User getWithMeals2(int id) {
/*        List<User> users = em.createNamedQuery(User.ALL_WITH_Meal, User.class)
                .setParameter("userId", id)
                .getResultList();

        return users.size() > 0 ? users.get(0) : null;*/

    TypedQuery query = em.createQuery("SELECT e FROM User e ", User.class);
//        TypedQuery query = em.createQuery("SELECT e FROM User e LEFT JOIN FETCH e.meals", User.class);
    List<User> resultList = query.getResultList();
    User user = resultList.get(0);
//        System.out.println(user.getMeals());
    return user;
  }

  @Transactional(readOnly = true)
  public User getWithMeals(int id) {
    User withMeals2 = getWithMeals2(id);
//    System.out.println(null);
    return withMeals2;
  }
}
