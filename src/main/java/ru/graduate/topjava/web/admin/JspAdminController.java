package ru.graduate.topjava.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/admin")
@Controller
public class JspAdminController {

  @GetMapping("")
  public String root() {
    System.out.println("2222222222222222222222222");
    return "adminControlPanel";
  }

}
