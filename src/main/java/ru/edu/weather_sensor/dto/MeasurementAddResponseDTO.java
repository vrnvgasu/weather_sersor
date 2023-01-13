package ru.edu.weather_sensor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementAddResponseDTO {

  private String value;

  private Boolean raining;

  private SensorDTO sensor;

}
