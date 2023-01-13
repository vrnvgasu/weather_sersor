package ru.edu.weather_sensor.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "sensors")
@SequenceGenerator(name = "app_sequence_generator", sequenceName = "sensors_id_seq", allocationSize = 1)
public class Sensor extends BaseModel {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
  private Set<Measurement> measurementSet;

}
