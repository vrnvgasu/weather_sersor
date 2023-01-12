package ru.edu.weather_sensor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measurements")
public class Measurement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

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
