package ru.graduate.topjava.service;

import java.time.LocalDateTime;

public interface TimeService {
  LocalDateTime getDateTime();
  void setDateTime(LocalDateTime dateTime);
}
