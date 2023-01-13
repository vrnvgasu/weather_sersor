package ru.edu.weather_sensor.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.weather_sensor.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

  boolean existsByName(String name);

  Optional<Sensor> findByName(String name);

}
