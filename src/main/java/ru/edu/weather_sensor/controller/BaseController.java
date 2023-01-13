package ru.edu.weather_sensor.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import ru.edu.weather_sensor.dto.RequestDTO;
import ru.edu.weather_sensor.exception.ValidationException;
import ru.edu.weather_sensor.util.ErrorBuilder;

public abstract class BaseController {

  protected void validate(Validator validator, RequestDTO dto, BindingResult bindingResult) {
    validator.validate(dto, bindingResult);
    String errors;
    if ((errors = ErrorBuilder.build(bindingResult)) != null) {
      throw new ValidationException(errors);
    }
  }

}
