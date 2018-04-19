package ru.graduate.topjava.to;

import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MenuWithCafe {
  public List<Menu> menuList;

  public static class Menu {
    private List<Meal> meals;
    private Cafe cafe;

    public List<Meal> getMeals() {
      return meals;
    }
    public void setMeals(List<Meal> meals) {
      this.meals = meals;
    }

    public Cafe getCafe() {
      return cafe;
    }
    public void setCafe(Cafe cafe) {
      this.cafe = cafe;
    }
  }

  public MenuWithCafe() {
    menuList = new ArrayList<>();
  }

  public List<Menu> getMenuList() {
    return menuList;
  }
}
