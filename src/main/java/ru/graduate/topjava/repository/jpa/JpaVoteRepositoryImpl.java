package ru.graduate.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduate.topjava.model.User;
import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.repository.VoteRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaVoteRepositoryImpl implements VoteRepository {

  @PersistenceContext
  private EntityManager em;

/*  @Override
  public Vote get(Integer id, int userId, LocalDateTime dateTime) {
    List<Vote> votes = em.createNamedQuery(Vote.GET_BY_USER_BY_DATETIME, Vote.class)
            .setParameter("userId", userId)
            .setParameter("dateTime", dateTime)
            .getResultList();
    return DataAccessUtils.singleResult(votes);
  }*/

  @Override
  public Vote get(Integer userId, LocalDate date) {
    LocalDateTime dateTime1 = date.atStartOfDay();
    LocalDateTime dateTime2 = dateTime1.plusDays(1);
    List<Vote> votes = em.createNamedQuery(Vote.GET_BY_USER_BY_DATE, Vote.class)
            .setParameter("userId", userId)
            .setParameter("dateTime1", dateTime1)
            .setParameter("dateTime2", dateTime2)
            .getResultList();
    return DataAccessUtils.singleResult(votes);
  }

  public Vote get(Integer voteId, Integer userId) {
    List<Vote> votes = em.createNamedQuery(Vote.GET_BY_ID_BY_USER, Vote.class)
            .setParameter("voteId", voteId)
            .setParameter("userId", userId)
            .getResultList();
    return DataAccessUtils.singleResult(votes);
  }

  @Override
  @Transactional
  public Vote save(Vote vote, Integer userId, LocalDateTime dateTime) { // TODO добавить проверку на dateTime
    if (!vote.isNew() && get(vote.getId(), userId) == null) {
      return null;
    }
    vote.setUser(em.getReference(User.class, userId));
    vote.setDateTime(dateTime);
    if (vote.isNew()) {
      em.persist(vote);
      return vote;
    } else {
      return em.merge(vote);
    }
  }

  @Override
  public List<Vote> getAll(LocalDate date) {
    Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
    LocalDateTime dateTime1 = timestamp.toLocalDateTime();
    LocalDateTime dateTime2 = dateTime1.plusDays(1);
    return em.createNamedQuery(Vote.GET_ALL_BY_DATE, Vote.class)
            .setParameter(1, dateTime1)
            .setParameter(2, dateTime2)
            .getResultList();
  }

  @Override
  @Transactional
  public boolean delete(int id, int userId, LocalDateTime dateTime) {
    LocalDateTime dateTime1 = dateTime.toLocalDate().atStartOfDay();
    LocalDateTime dateTime2 = dateTime1.plusDays(1);
    return em.createNamedQuery(Vote.DELETE)
            .setParameter("id", id)
            .setParameter("userId", userId)
            .setParameter("dateTime1", dateTime1)
            .setParameter("dateTime2", dateTime2)
            .executeUpdate() != 0;
  }
}
