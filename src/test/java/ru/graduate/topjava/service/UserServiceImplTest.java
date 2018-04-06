package ru.graduate.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduate.topjava.model.Role;
import ru.graduate.topjava.model.User;
import ru.graduate.topjava.util.exception.NotFoundException;

import static ru.graduate.topjava.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceImplTest {
  static {
    SLF4JBridgeHandler.install();
  }

  @Autowired
  protected UserService service;

  @Test
  public void get() {
    User user = service.get(USER_START_ID);
    assertMatch(user, ADMIN);
  }

  @Test(expected = NotFoundException.class)
  public void getNotFound() throws Exception {
    service.get(1);
  }

  @Test
  public void create() throws Exception {
    User newUser = new User(null, "New", Role.ROLE_USER);
    User created = service.create(newUser);
    newUser.setId(created.getId());
    assertMatch(service.getAll(), ADMIN, newUser, USER1, USER2, USER3);
  }
}
