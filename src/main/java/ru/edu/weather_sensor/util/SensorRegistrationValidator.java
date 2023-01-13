package ru.edu.weather_sensor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.edu.weather_sensor.dto.SensorRegistrationRequestDTO;
import ru.edu.weather_sensor.service.SensorService;

@Component
public class SensorRegistrationValidator implements Validator {

  private final SensorService sensorService;

  @Autowired
  public SensorRegistrationValidator(SensorService sensorService) {
    this.sensorService = sensorService;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return SensorRegistrationRequestDTO.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    SensorRegistrationRequestDTO requestDTO = (SensorRegistrationRequestDTO) target;

    if (sensorService.existsByName(requestDTO.getName())) {
      errors.rejectValue("name", "", "'name' is already exist");
    }
  }

}
