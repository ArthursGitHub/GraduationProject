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

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequestMapping(value = "/admin/meal")
@Controller
public class JspMealController {

  @Autowired
  private MealService service;

  @GetMapping("")
  public String root(Model model) {
//    model.addAttribute("meals", service.getAll());
    return "mealControlPanel";
  }

  @GetMapping("create")
  public String createMeal(HttpServletRequest request, Model model) {
    final Meal newMeal = new Meal();
    model.addAttribute("meal", newMeal);
    return "mealForm";
  }

  @GetMapping("update")
  public String updateMeal(HttpServletRequest request, Model model) {
    int id = getId(request);
//    Meal meal = service.get(id);
//    model.addAttribute("meal", meal);
    return "mealForm";
  }

  @GetMapping("delete")
  public String deleteMeal(HttpServletRequest request, Model model) {
    int id = getId(request);
//    service.delete(id);
    return "redirect:/admin/meal";
  }

  @PostMapping()
  public String setMeal(HttpServletRequest request) {
    String mealName = request.getParameter("name");
//    Meal meal = new Meal(null, mealName, Role.ROLE_Meal);

    String id = request.getParameter("id");
    if(id.isEmpty()){
//      service.create(meal);
    } else {
//      meal.setId(Integer.parseInt(id));
//      service.update(meal);
    }

    return "redirect:/admin/meal";
  }

  private int getId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("id"));
    return Integer.parseInt(paramId);
  }
}
