package ru.graduate.topjava;

import ru.graduate.topjava.model.Cafe;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.graduate.topjava.model.AbstractBaseEntity.START_SEQ;

public class CafeTestData {
  public static final int CAFE_ID = START_SEQ;

  public static final Cafe CAFE1 = new Cafe(CAFE_ID, "Взлет");
  public static final Cafe CAFE2 = new Cafe(CAFE_ID + 1, "Звездочка");
  public static final Cafe CAFE3 = new Cafe(CAFE_ID + 2, "Молодежное");

  public static void assertMatch(Cafe actual, Cafe expected) {
    assertThat(actual).isEqualToIgnoringGivenFields(expected);
  }

  public static void assertMatch(Iterable<Cafe> actual, Cafe... expected) {
    assertMatch(actual, Arrays.asList(expected));
  }

  public static void assertMatch(Iterable<Cafe> actual, Iterable<Cafe> expected) {
    assertThat(actual).isEqualTo(expected);
  }
}
