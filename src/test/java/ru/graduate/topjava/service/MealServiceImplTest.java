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
import ru.graduate.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.of;
import static ru.graduate.topjava.CafeTestData.CAFE1;
import static ru.graduate.topjava.CafeTestData.CAFE2;
import static ru.graduate.topjava.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceImplTest extends AbstractServiceTest {
  static {
    SLF4JBridgeHandler.install();
  }

  @Autowired
  private MealService service;


  @Test
  public void get() {
    Meal meal = service.get(MEAL1.getId(), CAFE1.getId());
    assertMatch(meal, MEAL1);
  }

  @Test
  public void getNotFound() throws Exception {
    thrown.expect(NotFoundException.class);
    service.get(MEAL1.getId(), CAFE2.getId());
  }

  @Test
  public void create() throws Exception {
    final LocalDate date = of(2015, 5, 23);
    Meal newMeal = new Meal(null, "4. Конфета", 90);
    Meal created = service.create(newMeal, CAFE1.getId(), date);
    assertMatch(service.getAll(CAFE1.getId(), date), MEAL3, MEAL13, MEAL23, newMeal);
  }





  @Test
  public void getAll() {
    LocalDate date = of(2015, 5, 23);
    List<Meal> meals = service.getAll(CAFE1.getId(), date);
    assertMatch(meals, MEAL3, MEAL13, MEAL23);
  }
}
