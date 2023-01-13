package ru.edu.weather_sensor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.edu.weather_sensor.dto.MeasurementAddRequestDTO;
import ru.edu.weather_sensor.dto.SensorDTO;
import ru.edu.weather_sensor.dto.SensorRegistrationRequestDTO;
import ru.edu.weather_sensor.service.SensorService;

@Component
public class MeasurementAddValidator implements Validator {

  private final SensorService sensorService;

  @Autowired
  public MeasurementAddValidator(SensorService sensorService) {
    this.sensorService = sensorService;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return SensorRegistrationRequestDTO.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    MeasurementAddRequestDTO requestDTO = (MeasurementAddRequestDTO) target;
    SensorDTO sensorDTO = requestDTO.getSensor();

    if (!sensorService.existsByName(sensorDTO.getName())) {
      errors.rejectValue("sensor", "", "sensor is not exist");
    }
  }

}
