package ru.graduate.topjava.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.model.Meal;
import ru.graduate.topjava.service.CafeService;
import ru.graduate.topjava.service.MealService;
import ru.graduate.topjava.service.TimeService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RequestMapping(value = "/admin/cafe")
@Controller
public class JspCafeController {

  @Autowired
  private CafeService service;

  @Autowired
  private MealService mealService;

  @Autowired
  private TimeService timeService;

  @GetMapping("")
  public String root(Model model) {
    model.addAttribute("cafes", service.getAll());
    return "cafeControlPanel";
  }

  @GetMapping("create")
  public String createCafe(HttpServletRequest request, Model model) {
    final Cafe newCafe = new Cafe(null, "");
    model.addAttribute("cafe", newCafe);
    return "cafeForm";
  }

  @GetMapping("update")
  public String updateCafe(HttpServletRequest request, Model model) {
    int id = getId(request);
    Cafe cafe = service.get(id);
    model.addAttribute("cafe", cafe);
    return "cafeForm";
  }

  @GetMapping("delete")
  public String deleteCafe(HttpServletRequest request, Model model) {
    int id = getId(request);
    service.delete(id);
    return "redirect:/admin/cafe";
  }

  @PostMapping()
  public String setCafe(HttpServletRequest request) {
    String cafeName = request.getParameter("name");
    Cafe cafe = new Cafe(null, cafeName);

    String id = request.getParameter("id");
    if(id.isEmpty()){
      service.create(cafe);
    } else {
      cafe.setId(Integer.parseInt(id));
      service.update(cafe);
    }

    return "redirect:/admin/cafe";
  }

  @GetMapping("menu")
  public String cafeMenu(HttpServletRequest request, Model model) {
    int id = getId(request);
    LocalDate localDate = timeService.getDateTime().toLocalDate();
    List<Meal> meals = mealService.getAll(id, localDate);
    model.addAttribute("meals", meals);
    return "menu";
  }

  private int getId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("id"));
    return Integer.parseInt(paramId);
  }
}
