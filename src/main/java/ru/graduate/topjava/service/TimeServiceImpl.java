package ru.graduate.topjava.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeServiceImpl implements TimeService {
  private LocalDateTime dateTime;

  @Override
  public LocalDateTime getDateTime() {
    return dateTime;
  }

  @Override
  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }
}
