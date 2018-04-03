package ru.graduate.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.graduate.topjava.AuthorizedUser;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.service.MealService;

import static ru.graduate.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.graduate.topjava.util.ValidationUtil.checkNew;


@Controller
public class MealRestController {
  private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

  private final MealService service;

  @Autowired
  public MealRestController(MealService service) {
    this.service = service;
  }

  public Meal get(int id) {
    int userId = AuthorizedUser.id();
    log.info("get meal {} for user {}", id, userId);
    return service.get(id, userId);
  }

  public void delete(int id) {
    int userId = AuthorizedUser.id();
    log.info("delete meal {} for user {}", id, userId);
    service.delete(id, userId);
  }

/*  public List<MealWithExceed> getAll() {
    int userId = AuthorizedUser.id();
    log.info("getAll for user {}", userId);
    return MealsUtil.getWithExceeded(service.getAll(userId), AuthorizedUser.getCaloriesPerDay());
  }*/

  public Meal create(Meal meal) {
    int userId = AuthorizedUser.id();
    checkNew(meal);
    log.info("create {} for user {}", meal, userId);
    return service.create(meal, userId);
  }

  public void update(Meal meal, int id) {
    int userId = AuthorizedUser.id();
    assureIdConsistent(meal, id);
    log.info("update {} for user {}", meal, userId);
    service.update(meal, userId);
  }
}