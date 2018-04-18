package ru.graduate.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.graduate.topjava.model.Role;
import ru.graduate.topjava.model.User;
import ru.graduate.topjava.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequestMapping(value = "/user")
@Controller
public class JspUserPanelController {

  @Autowired
  private UserService service;

  @GetMapping("")
  public String root(Model model) {
    model.addAttribute("users", service.getAll());
    return "user/userPanel";
  }



  private int getId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("id"));
    return Integer.parseInt(paramId);
  }
}
