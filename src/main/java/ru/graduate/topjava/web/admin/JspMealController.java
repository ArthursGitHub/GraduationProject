package ru.graduate.topjava.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.graduate.topjava.model.Role;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.service.MealService;
import ru.graduate.topjava.service.TimeService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

@RequestMapping(value = "/admin/cafe/meal")
@Controller
public class JspMealController {

  @Autowired
  private MealService service;

  @Autowired
  private TimeService timeService;

  @GetMapping("")
  public String root(Model model) {
//    model.addAttribute("meals", service.getAll());
    return "mealControlPanel";
  }

  @GetMapping("create")
  public String createMeal(HttpServletRequest request, Model model) {
    final Meal newMeal = new Meal();
    model.addAttribute("meal", newMeal);
    return "menuForm";
  }

  @GetMapping("update")
  public String updateMeal(HttpServletRequest request, Model model) {
    int id = getId(request);
    int cafeId = getCafeId(request);
    Meal meal = service.get(id, cafeId);
    model.addAttribute("meal", meal);
    return "menuForm";
  }

  @GetMapping("delete")
  public String deleteMeal(HttpServletRequest request, Model model) {
    int id = getId(request);
    int cafeId = getCafeId(request);
    service.delete(id, cafeId);
    return "redirect:/admin/cafe/menu";
  }

  @PostMapping()
  public String setMeal(HttpServletRequest request) {
    LocalDate localDate = timeService.getDateTime().toLocalDate();

    String name = request.getParameter("name");
    String priceVal = request.getParameter("price");
    String cafeIdVal = request.getParameter("cafeId");

    int price = Integer.parseInt(priceVal);
    int cafeId = Integer.parseInt(cafeIdVal);

    Meal meal = new Meal(null, name, price);

    String id = request.getParameter("id");
    if(id.isEmpty()){
      service.create(meal, cafeId, localDate);
    } else {
      meal.setId(Integer.parseInt(id));
      service.update(meal, cafeId, localDate);
    }

    return "redirect:/admin/cafe/menu";
  }

  private int getId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("id"));
    return Integer.parseInt(paramId);
  }

  private int getCafeId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("cafeId"));
    return Integer.parseInt(paramId);
  }
}
