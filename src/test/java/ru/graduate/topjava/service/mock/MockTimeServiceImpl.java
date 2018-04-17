package ru.graduate.topjava.service.mock;

import org.springframework.stereotype.Service;
import ru.graduate.topjava.service.TimeService;

import java.time.LocalDateTime;

@Service
public class MockTimeServiceImpl implements TimeService {
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
