package ru.edu.weather_sensor.util;

import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorBuilder {

  public static String build(BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      return null;
    }

    StringBuilder errorMessage = new StringBuilder();
    List<FieldError> errors = bindingResult.getFieldErrors();

    for (FieldError error : errors) {
      errorMessage.append(error.getField())
          .append(" - ")
          .append(error.getDefaultMessage())
          .append(";");
    }

    return errorMessage.toString();
  }

}
