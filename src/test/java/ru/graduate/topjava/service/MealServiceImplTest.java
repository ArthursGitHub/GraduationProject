package ru.graduate.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduate.topjava.model.Meal;

import java.time.LocalDate;
import java.util.List;

import static ru.graduate.topjava.CafeTestData.CAFE_START_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceImplTest {
  static {
    SLF4JBridgeHandler.install();
  }

  @Autowired
  private MealService service;


  @Test
  public void get() {
    Meal meal = service.get(100011, CAFE_START_ID + 1);
    System.out.println(meal);
    System.out.println("********************");
  }

  @Test
  public void getAll() {
    LocalDate date = LocalDate.of(2015, 5, 23);
    List<Meal> meals = service.getAll(CAFE_START_ID + 1, date);
    for (Meal meal : meals) {
      System.out.println(meal);
    }
    System.out.println("********************");
  }
}