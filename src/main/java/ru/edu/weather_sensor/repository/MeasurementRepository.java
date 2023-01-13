package ru.edu.weather_sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.weather_sensor.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}
