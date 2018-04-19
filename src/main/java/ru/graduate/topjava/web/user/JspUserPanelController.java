package ru.graduate.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.graduate.topjava.service.MenuService;
import ru.graduate.topjava.service.TimeService;
import ru.graduate.topjava.to.MenuWithCafe;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@RequestMapping(value = "/user")
@Controller
public class JspUserPanelController {

  @Autowired
  private MenuService menuService;

  @Autowired
  private TimeService timeService;

  @GetMapping("")
  public String root(Model model) {
    LocalDate localDate = timeService.getDateTime().toLocalDate();
    MenuWithCafe menu = menuService.getMenu(localDate);
    model.addAttribute("menu", menu);
    return "user/userPanel";
  }

  @PostMapping("vote")
  public String setVote(HttpServletRequest request) {
    String cafeId = request.getParameter("cafeId");
    System.out.println(cafeId);
    return "index";
  }
}
