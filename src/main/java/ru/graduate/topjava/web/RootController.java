package ru.graduate.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.graduate.topjava.AuthorizedUser;
import ru.graduate.topjava.service.MealService;
import ru.graduate.topjava.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
//  @Autowired
//  private UserService service;
//
//  @Autowired
//  private MealService mealService;

  @GetMapping("/")
  public String root() {
    return "index";
  }

/*  @GetMapping("/users")
  public String users(Model model) {
    model.addAttribute("users", service.getAll());
    return "users";
  }

  @PostMapping("/users")
  public String setUser(HttpServletRequest request) {
    int userId = Integer.valueOf(request.getParameter("userId"));
    AuthorizedUser.setId(userId);
    return "redirect:meals";
  }

  @GetMapping("/meals")
  public String meals(Model model) {
    model.addAttribute("meals", MealsUtil.getWithExceeded(mealService.getAll(AuthorizedUser.id()), AuthorizedUser.getCaloriesPerDay()));
    return "meals";
  }*/
}
