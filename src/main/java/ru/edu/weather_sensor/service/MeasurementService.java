package ru.edu.weather_sensor.service;

import org.springframework.stereotype.Service;
import ru.edu.weather_sensor.repository.MeasurementRepository;

@Service
public class MeasurementService {

  private final MeasurementRepository repository;

  public MeasurementService(MeasurementRepository repository) {
    this.repository = repository;
  }

}
