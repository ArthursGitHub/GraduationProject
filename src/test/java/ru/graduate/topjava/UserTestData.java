package ru.graduate.topjava;

import ru.graduate.topjava.model.Role;
import ru.graduate.topjava.model.User;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.graduate.topjava.CafeTestData.CAFE_END_ID;

public class UserTestData {
  public static final int USER_START_ID = CAFE_END_ID + 1;

  public static final User ADMIN = new User(USER_START_ID, "Admin", Role.ROLE_ADMIN);
  public static final User USER1 = new User(USER_START_ID + 1, "User1", Role.ROLE_USER);
  public static final User USER2 = new User(USER_START_ID + 2, "User2", Role.ROLE_USER);
  public static final User USER3 = new User(USER_START_ID + 3, "User3", Role.ROLE_USER);

  public static final int USER_END_ID = USER3.getId();

  public static User getUpdated() {
    return new User(USER_START_ID, "NewUser", Role.ROLE_USER);
  }

  public static void assertMatch(User actual, User expected) {
    assertThat(actual).isEqualToIgnoringGivenFields(expected);
  }

  public static void assertMatch(Iterable<User> actual, User... expected) {
    assertMatch(actual, Arrays.asList(expected));
  }

  public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
    assertThat(actual).isEqualTo(expected);
  }
}
