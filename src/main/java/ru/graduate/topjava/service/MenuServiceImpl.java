package ru.graduate.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.to.MenuWithCafe;

import java.time.LocalDate;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

  @Autowired
  private CafeService cafeService;

  @Autowired
  private MealService mealService;

  @Override
  public MenuWithCafe getMenu(LocalDate date) {
    MenuWithCafe menuWrapper = new MenuWithCafe();

    List<Cafe> cafeList = cafeService.getAll();
    for (Cafe cafe : cafeList) {
      Integer cafeId = cafe.getId();

      List<Meal> meals = mealService.getAll(cafeId, date);
      if(!meals.isEmpty()) {
        List<MenuWithCafe.Menu> menuList = menuWrapper.getMenuList();
        MenuWithCafe.Menu menu = new MenuWithCafe.Menu();
        menu.setMeals(meals);
        menu.setCafe(cafe);
        menuList.add(menu);
      }
    }

    return menuWrapper;
  }
}
