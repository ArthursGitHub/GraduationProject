package ru.graduate.topjava.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeServiceImpl implements TimeService {

  @Override
  public LocalDateTime getDateTime() {
    return LocalDateTime.now();
  }

  @Override
  public void setDateTime(LocalDateTime dateTime) {
  }
}
