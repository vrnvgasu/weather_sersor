package ru.edu.weather_sensor.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorRequestDTO {

  @NotEmpty(message = "'name' must not be empty string")
  private String name;

}
