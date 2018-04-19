package ru.graduate.topjava.service;

import ru.graduate.topjava.to.MenuWithCafe;

import java.time.LocalDate;

public interface MenuService {
  MenuWithCafe getMenu(LocalDate date);
}
