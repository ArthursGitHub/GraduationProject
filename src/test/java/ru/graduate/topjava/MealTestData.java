package ru.graduate.topjava;

import ru.graduate.topjava.model.Meal;

import java.time.LocalDate;
import java.util.Arrays;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static ru.graduate.topjava.CafeTestData.*;
import static ru.graduate.topjava.UserTestData.USER_END_ID;

public class MealTestData {
  public static final int MEAL_START_ID = USER_END_ID + 1;

  private static final LocalDate DATE21 = of(2015, 5, 21);
  private static final LocalDate DATE22 = of(2015, 5, 22);
  private static final LocalDate DATE23 = of(2015, 5, 23);
  private static final LocalDate DATE24 = of(2015, 5, 24);

  public static final Meal MEAL1  = new Meal(MEAL_START_ID        , "1. Суп овощной", 90, CAFE1, DATE21);
  public static final Meal MEAL2  = new Meal(MEAL_START_ID + 1, "1. Суп гороховый", 90, CAFE1, DATE22);
  public static final Meal MEAL3  = new Meal(MEAL_START_ID + 2, "1. Борщ", 90, CAFE1, DATE23);
  public static final Meal MEAL4  = new Meal(MEAL_START_ID + 3, "1. Рассольник", 90, CAFE2, DATE21);
  public static final Meal MEAL5  = new Meal(MEAL_START_ID + 4, "1. Молочный суп", 90, CAFE2, DATE22);
  public static final Meal MEAL6  = new Meal(MEAL_START_ID + 5, "1. Грибной суп", 90, CAFE2, DATE23);
  public static final Meal MEAL7  = new Meal(MEAL_START_ID + 6, "1. Похлебка", 90, CAFE3, DATE21);
  public static final Meal MEAL8  = new Meal(MEAL_START_ID + 7, "1. Солянка", 90, CAFE3, DATE22);
  public static final Meal MEAL9  = new Meal(MEAL_START_ID + 8, "1. Рыбный суп", 90, CAFE3, DATE23);
  public static final Meal MEAL10 = new Meal(MEAL_START_ID + 9, "1. Суп с фрикадельками", 90, CAFE3, DATE24);

  public static final Meal MEAL11 = new Meal(MEAL_START_ID + 10, "2. Макароны с мясом", 90, CAFE1, DATE21);
  public static final Meal MEAL12 = new Meal(MEAL_START_ID + 11, "2. Картошка с мясом", 90, CAFE1, DATE22);
  public static final Meal MEAL13 = new Meal(MEAL_START_ID + 12, "2. Пицца", 90, CAFE1, DATE23);
  public static final Meal MEAL14 = new Meal(MEAL_START_ID + 13, "2. Тушеное мясо в горшочке", 90, CAFE2, DATE21);
  public static final Meal MEAL15 = new Meal(MEAL_START_ID + 14, "2. Куриное филу", 90, CAFE2, DATE22);
  public static final Meal MEAL16 = new Meal(MEAL_START_ID + 15, "2. Горбуша в духовке", 90, CAFE2, DATE23);
  public static final Meal MEAL17 = new Meal(MEAL_START_ID + 16, "2. Котлеты с гречей", 90, CAFE3, DATE21);
  public static final Meal MEAL18 = new Meal(MEAL_START_ID + 17, "2. Макароны с сосисками", 90, CAFE3, DATE22);
  public static final Meal MEAL19 = new Meal(MEAL_START_ID + 18, "2. Яичница", 90, CAFE3, DATE23);
  public static final Meal MEAL20 = new Meal(MEAL_START_ID + 19, "2. Пельмени", 90, CAFE3, DATE24);

  public static final Meal MEAL21 = new Meal(MEAL_START_ID + 20, "3. Морс", 90, CAFE1, DATE21);
  public static final Meal MEAL22 = new Meal(MEAL_START_ID + 21, "3. Какао", 90, CAFE1, DATE22);
  public static final Meal MEAL23 = new Meal(MEAL_START_ID + 22, "3. Молоко", 50, CAFE1, DATE23);
  public static final Meal MEAL24 = new Meal(MEAL_START_ID + 23, "3. Сбитень", 90, CAFE2, DATE21);
  public static final Meal MEAL25 = new Meal(MEAL_START_ID + 24, "3. Глинтвейн", 90, CAFE2, DATE22);
  public static final Meal MEAL26 = new Meal(MEAL_START_ID + 25, "3. Лимонад", 90, CAFE2, DATE23);
  public static final Meal MEAL27 = new Meal(MEAL_START_ID + 26, "3. Кисель", 90, CAFE3, DATE21);
  public static final Meal MEAL28 = new Meal(MEAL_START_ID + 27, "3. Чай", 90, CAFE3, DATE22);
  public static final Meal MEAL29 = new Meal(MEAL_START_ID + 28, "3. Сок", 90, CAFE3, DATE23);
  public static final Meal MEAL30 = new Meal(MEAL_START_ID + 29, "3. Кампот", 90, CAFE3, DATE24);

  public static final int MEAL_END_ID = MEAL30.getId();


  public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
    assertMatch(actual, Arrays.asList(expected));
  }

  public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
    assertThat(actual).usingElementComparatorIgnoringFields("cafe").isEqualTo(expected);
  }
}
