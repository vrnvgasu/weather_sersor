package ru.edu.weather_sensor.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementSensorResponseDTO {

  private Long id;

  private Float value;

  private Boolean raining;

  private LocalDateTime time;

  private SensorResponseDTO sensor;

}
