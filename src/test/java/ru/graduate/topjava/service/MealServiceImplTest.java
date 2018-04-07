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
import static ru.graduate.topjava.CafeTestData.CAFE_START_ID;

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
    Meal meal = service.get(100011, CAFE_START_ID + 1);
    System.out.println(meal);
    System.out.println(meal.getCafe());
    System.out.println("********************");
  }

  @Test
  public void getNotFound() throws Exception {
    thrown.expect(NotFoundException.class);
    service.get(100011, CAFE_START_ID);
  }

  @Test
  public void create() throws Exception {
    final LocalDate date = of(2015, 5, 23);
    Meal newMeal = new Meal(null, "Борщ", 90);
    Meal created = service.create(newMeal, CAFE_START_ID, date);
/*
    newMeal.setId(created.getId());
*/
//    assertMatch(service.getAll(), ADMIN, newMeal, USER1, USER2, USER3);
  }
  
  
  
  
  @Test
  public void getAll() {
    LocalDate date = of(2015, 5, 23);
    List<Meal> meals = service.getAll(CAFE_START_ID + 1, date);
    for (Meal meal : meals) {
      System.out.println(meal + "\n");
    }
    System.out.println("********************");
  }
}
