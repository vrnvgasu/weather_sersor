package ru.edu.weather_sensor.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
public class MeasurementAddRequestDTO implements RequestDTO {

  @NotNull(message = "'value' must not be empty float")
  @Min(value = -100, message = "min value is -100")
  @Max(value = 100, message = "max value is 100")
  private Float value;

  @NotNull(message = "'raining' must not be empty boolean")
  private Boolean raining;

  @Valid
  @NotNull(message = "'sensor' must not be null")
  private SensorRequestDTO sensor;

}
