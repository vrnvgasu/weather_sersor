package ru.edu.weather_sensor.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.weather_sensor.dto.SensorRegistrationRequestDTO;
import ru.edu.weather_sensor.model.Sensor;
import ru.edu.weather_sensor.repository.SensorRepository;

@Service
public class SensorService {

  private final SensorRepository repository;

  private final ModelMapper modelMapper;

  @Autowired
  public SensorService(SensorRepository repository, ModelMapper modelMapper) {
    this.repository = repository;
    this.modelMapper = modelMapper;
  }

  public Sensor createFromDTO(SensorRegistrationRequestDTO dto) {
    return repository.save(modelMapper.map(dto, Sensor.class));
  }

  public boolean existsByName(String name) {
    return repository.existsByName(name);
  }

}
