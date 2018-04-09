package ru.graduate.topjava;

import ru.graduate.topjava.model.Vote;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.graduate.topjava.CafeTestData.CAFE1;
import static ru.graduate.topjava.MealTestData.MEAL_END_ID;
import static ru.graduate.topjava.UserTestData.USER1;

public class VoteTestData {
  public static final int VOTE_START_ID = MEAL_END_ID + 1;

  private static final LocalDateTime DATE21 = LocalDateTime.of(2015, 5, 21, 10, 0);
//, DATE21, USER1.getId(), CAFE1.getId()

  public static final Vote VOTE1 = new Vote(VOTE_START_ID, USER1, CAFE1, DATE21);
  public static final Vote VOTE2 = new Vote(VOTE_START_ID + 1);
  public static final Vote VOTE3 = new Vote(VOTE_START_ID + 2);
  public static final Vote VOTE4 = new Vote(VOTE_START_ID + 3);
  public static final Vote VOTE5 = new Vote(VOTE_START_ID + 4);
  public static final Vote VOTE6 = new Vote(VOTE_START_ID + 5);
  public static final Vote VOTE7 = new Vote(VOTE_START_ID + 6);
  public static final Vote VOTE8 = new Vote(VOTE_START_ID + 7);
  public static final Vote VOTE9 = new Vote(VOTE_START_ID + 8);
  public static final Vote VOTE10 = new Vote(VOTE_START_ID + 9);

  public static final int VOTE_END_ID = VOTE10.getId();


  public static void assertMatch(Vote actual, Vote expected) {
    assertThat(actual).isEqualToIgnoringGivenFields(expected);
  }

  public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
    assertMatch(actual, Arrays.asList(expected));
  }

  public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
    assertThat(actual).isEqualTo(expected);
  }
}
