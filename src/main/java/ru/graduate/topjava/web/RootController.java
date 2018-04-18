package ru.graduate.topjava.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.graduate.topjava.AuthorizedUser;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

  @GetMapping("/")
  public String root() {
    return "index";
  }

  @PostMapping("/users")
  public String setUser(HttpServletRequest request) {
    int userId = Integer.valueOf(request.getParameter("userId"));
    AuthorizedUser.setId(userId);
    switch (userId) {
      case 100000 : {
        return "redirect:admin";
      }
      default:{
        return "redirect:user";
      }
    }
  }

//  @GetMapping("/meals")
//  public String rootAd() {
//    System.out.println("1111111111111111");
//    return "controlPanel";
//  }
}
