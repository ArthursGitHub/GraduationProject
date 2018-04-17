package ru.graduate.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduate.topjava.model.Vote;
import ru.graduate.topjava.util.exception.VotingReglamentExeption;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.graduate.topjava.CafeTestData.CAFE3;
import static ru.graduate.topjava.UserTestData.USER1;
import static ru.graduate.topjava.VoteTestData.VOTE1;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class VoteServiceImplTest extends AbstractServiceTest {
  static {
    SLF4JBridgeHandler.install();
  }

  @Autowired
  private TimeService timeService;

  @Autowired
  protected VoteService service;


/*  @Test
  public void get2() {  // ??????
    LocalDateTime dateTime = LocalDateTime.of(2015, 5, 21, 10, 0);
    Vote vote = service.get(VOTE1.getId(), USER1.getId(), dateTime);
    System.out.println(vote);
  }*/

  @Test
  public void get() {
    // Get a vote of the specified user for the certain date
    LocalDate date = LocalDate.of(2015, 5, 21);
    Vote vote = service.get(USER1.getId(), date);
    System.out.println(vote);
  }

  @Test
  public void create() throws Exception {
    LocalDateTime systemDateTime = LocalDateTime.of(2015, 5, 21, 10, 30);
    timeService.setDateTime(systemDateTime);

    Vote newVote = new Vote();
    newVote.setCafe(CAFE3);

    service.create(newVote, USER1.getId());

    List<Vote> votes = service.getAll(systemDateTime.toLocalDate());
    for (Vote vote : votes) {
      System.out.println(vote + "\n");
    }
  }

  @Test
  public void createAfterReglamentTime() {
    thrown.expect(VotingReglamentExeption.class);

    LocalDateTime systemDateTime = LocalDateTime.of(2015, 5, 21, 11, 01);
    timeService.setDateTime(systemDateTime);

    Vote newVote = new Vote();
    newVote.setCafe(CAFE3);

    service.create(newVote, USER1.getId());
  }


  @Test
  public void delete() throws Exception {
    LocalDateTime dateTime = LocalDateTime.of(2015, 5, 21, 7, 30);

    List<Vote> votes = service.getAll(dateTime.toLocalDate());

    for (Vote vote : votes) {
      System.out.println(vote);
      System.out.println(vote.getCafe());
      System.out.println("--------------------");
    }

    service.delete(VOTE1.getId(), USER1.getId(), dateTime);

    votes = service.getAll(dateTime.toLocalDate());

    for (Vote vote : votes) {
      System.out.println(vote);
      System.out.println(vote.getCafe());
      System.out.println("--------------------");
    }
  }

  @Test
  public void update() throws Exception {
    Vote updated = new Vote(VOTE1);
    LocalDateTime dateTime = LocalDateTime.of(2015, 5, 21, 7, 30);

    updated.setCafe(CAFE3);
    service.update(updated, USER1.getId(), dateTime);

    Vote vote = service.get(USER1.getId(), dateTime.toLocalDate());
    System.out.println(vote);
  }

  @Test
  public void getAll() throws Exception {
    // Get all votes for the specified date
    LocalDate date = LocalDate.of(2015, 5, 21);

    List<Vote> votes = service.getAll(date);

    for (Vote vote : votes) {
      System.out.println(vote);
      System.out.println(vote.getCafe());
      System.out.println("--------------------");
    }
  }
}
