package ru.edu.weather_sensor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.edu.weather_sensor.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

  @Query("select m from Measurement m left join m.sensor")
  List<Measurement> getAllWithSensor();

}
