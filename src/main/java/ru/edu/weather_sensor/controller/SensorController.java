package ru.edu.weather_sensor.controller;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.weather_sensor.dto.SensorRegistrationRequestDTO;
import ru.edu.weather_sensor.dto.SensorRegistrationResponseDTO;
import ru.edu.weather_sensor.model.Sensor;
import ru.edu.weather_sensor.service.SensorService;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

  private final SensorService service;

  private final ModelMapper modelMapper;

  @Autowired
  public SensorController(SensorService service, ModelMapper modelMapper) {
    this.service = service;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/registration")
  public ResponseEntity<SensorRegistrationResponseDTO> registration(
      @RequestBody @Valid SensorRegistrationRequestDTO requestDTO) {
    Sensor sensor = service.createFromDTO(requestDTO);
    SensorRegistrationResponseDTO responseDTO = modelMapper.map(sensor, SensorRegistrationResponseDTO.class);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

}
