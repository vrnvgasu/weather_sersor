package ru.edu.weather_sensor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "measurements")
@SequenceGenerator(name = "app_sequence_generator", sequenceName = "measurements_id_seq", allocationSize = 1)
public class Measurement extends BaseModel {

  @Column(name = "value", nullable = false)
  private Float value;

  @Column(name = "raining", nullable = false)
  private Boolean raining;

  @Column(name = "time", nullable = false)
  private LocalDateTime time;

  @Column(name = "sensor_id", nullable = false)
  private Long sensorId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sensor_id", referencedColumnName = "id", updatable = false, insertable = false)
  @JsonIgnore
  private Sensor sensor;

}
