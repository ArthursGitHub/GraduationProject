package ru.graduate.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.util.exception.NotFoundException;

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
    Cafe cafe = service.get(CAFE1_ID);
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

  @Test
  public void duplicateCreate() throws Exception {
    Cafe newCafe = new Cafe(null, CAFE2.getName());
    thrown.expect(DataAccessException.class);
    service.create(newCafe);
  }

  @Test
  public void delete() throws Exception {
    service.delete(CAFE1_ID);
    assertMatch(service.getAll(), CAFE2, CAFE3);
  }

  @Test
  public void deleteNotFound() throws Exception {
    thrown.expect(NotFoundException.class);
    service.delete(1);
  }

  @Test
  public void update() throws Exception {
    Cafe updated = getUpdated();
    service.update(updated);
    assertMatch(service.get(CAFE1_ID), updated);
  }

  @Test
  public void getAll() throws Exception {
    assertMatch(service.getAll(), CAFE1, CAFE2, CAFE3);
  }
}
