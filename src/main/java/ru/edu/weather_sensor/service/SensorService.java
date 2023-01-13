package ru.edu.weather_sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.weather_sensor.repository.SensorRepository;

@Service
public class SensorService {

  private final SensorRepository repository;

  @Autowired
  public SensorService(SensorRepository repository) {
    this.repository = repository;
  }

}
