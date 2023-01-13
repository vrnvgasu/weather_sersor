package ru.edu.weather_sensor.service;

import java.time.LocalDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.edu.weather_sensor.dto.MeasurementAddRequestDTO;
import ru.edu.weather_sensor.model.Measurement;
import ru.edu.weather_sensor.model.Sensor;
import ru.edu.weather_sensor.repository.MeasurementRepository;

@Service
public class MeasurementService {

  private final MeasurementRepository repository;

  private final SensorService sensorService;

  private final ModelMapper modelMapper;

  public MeasurementService(MeasurementRepository repository, SensorService sensorService, ModelMapper modelMapper) {
    this.repository = repository;
    this.sensorService = sensorService;
    this.modelMapper = modelMapper;
  }

  public Measurement createFromDTO(MeasurementAddRequestDTO requestDTO) {
    Sensor sensor = sensorService.findByName(requestDTO.getSensor().getName());
    Measurement measurementForSave = Measurement.builder()
        .value(requestDTO.getValue())
        .raining(requestDTO.getRaining())
        .time(LocalDateTime.now())
        .sensorId(sensor.getId())
        .build();
    Measurement measurement = repository.save(measurementForSave);
    measurement.setSensor(sensor);

    return measurement;
  }

}
