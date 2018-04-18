package ru.graduate.topjava.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.graduate.topjava.service.CafeService;

@RequestMapping(value = "/admin/cafe")
@Controller
public class JspCafeController {

  @Autowired
  private CafeService service;

  @GetMapping("")
  public String root(Model model) {
    System.out.println("44444444444");
    model.addAttribute("cafes", service.getAll());
    return "cafeControlPanel";
  }

  @GetMapping("create")
  public String createCafe() {
    return "cafeForm";
  }

  @GetMapping("update")
  public String updateCafe() {
    return "cafeForm";
  }

  @GetMapping("delete")
  public String deleteCafe() {
    return "redirect:/admin/cafe";
  }
}
