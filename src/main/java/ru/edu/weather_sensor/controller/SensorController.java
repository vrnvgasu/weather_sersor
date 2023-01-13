package ru.edu.weather_sensor.controller;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.weather_sensor.dto.SensorRegistrationRequestDTO;
import ru.edu.weather_sensor.dto.SensorRegistrationResponseDTO;
import ru.edu.weather_sensor.model.Sensor;
import ru.edu.weather_sensor.service.SensorService;
import ru.edu.weather_sensor.util.SensorRegistrationValidator;

@RestController
@RequestMapping("/api/sensors")
public class SensorController extends BaseController {

  private final SensorService service;

  private final ModelMapper modelMapper;

  private final SensorRegistrationValidator registrationValidator;

  @Autowired
  public SensorController(SensorService service, ModelMapper modelMapper,
      SensorRegistrationValidator registrationValidator) {
    this.service = service;
    this.modelMapper = modelMapper;
    this.registrationValidator = registrationValidator;
  }

  @PostMapping("/registration")
  public ResponseEntity<SensorRegistrationResponseDTO> registration(
      @RequestBody @Valid SensorRegistrationRequestDTO requestDTO, BindingResult bindingResult) {
    registrationValidator.validate(requestDTO, bindingResult);
    validate(registrationValidator, requestDTO, bindingResult);

    Sensor sensor = service.createFromDTO(requestDTO);
    SensorRegistrationResponseDTO responseDTO = modelMapper.map(sensor, SensorRegistrationResponseDTO.class);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

}
