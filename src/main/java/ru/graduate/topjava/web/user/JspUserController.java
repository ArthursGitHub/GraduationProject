package ru.graduate.topjava.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
@Controller
public class JspUserController {

  @GetMapping("")
  public String root() {
    System.out.println("2222222222222222222222222");
    return "userControlPanel";
  }

}
