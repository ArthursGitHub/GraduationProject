package ru.graduate.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.util.exception.NotFoundException;

import static org.junit.Assert.*;
import static ru.graduate.topjava.CafeTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class CafeServiceImplTest extends AbstractServiceTest {
  static {
    SLF4JBridgeHandler.install();
  }

  @Autowired
  private CafeService service;


  @Test
  public void get() {
    Cafe cafe = service.get(CAFE_ID);
    System.out.println(cafe);
    assertMatch(cafe, CAFE1);
  }

  @Test
  public void getNotFound() throws Exception {
    thrown.expect(NotFoundException.class);
    service.get(1);
  }

  @Test
  public void create() throws Exception {
    Cafe newCafe = new Cafe(null, "Пилигрим");
    Cafe created = service.create(newCafe);
    newCafe.setId(created.getId());
    assertMatch(service.getAll(), CAFE1, CAFE2, CAFE3, newCafe);
  }
}
