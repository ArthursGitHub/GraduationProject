package ru.graduate.topjava.web.admin;

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

@RequestMapping(value = "/admin/user")
@Controller
public class JspUserController {

  @Autowired
  private UserService service;

  @GetMapping("")
  public String root(Model model) {
    model.addAttribute("users", service.getAll());
    return "userControlPanel";
  }

  @GetMapping("create")
  public String createUser(HttpServletRequest request, Model model) {
    final User newUser = new User();
    model.addAttribute("user", newUser);
    return "userForm";
  }

  @GetMapping("update")
  public String updateUser(HttpServletRequest request, Model model) {
    int id = getId(request);
    User user = service.get(id);
    model.addAttribute("user", user);
    return "userForm";
  }

  @GetMapping("delete")
  public String deleteUser(HttpServletRequest request, Model model) {
    int id = getId(request);
    service.delete(id);
    return "redirect:/admin/user";
  }

  @PostMapping()
  public String setUser(HttpServletRequest request) {
    String userName = request.getParameter("name");
    User user = new User(null, userName, Role.ROLE_USER);

    String id = request.getParameter("id");
    if(id.isEmpty()){
      service.create(user);
    } else {
      user.setId(Integer.parseInt(id));
      service.update(user);
    }

    return "redirect:/admin/user";
  }

  private int getId(HttpServletRequest request) {
    String paramId = Objects.requireNonNull(request.getParameter("id"));
    return Integer.parseInt(paramId);
  }
}
