package ru.graduate.topjava.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.graduate.topjava.model.Cafe;
import ru.graduate.topjava.service.CafeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequestMapping(value = "/admin/cafe")
@Controller
public class JspCafeController {

  @Autowired
  private CafeService service;

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

  private int getId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("id"));
    return Integer.parseInt(paramId);
  }
}
