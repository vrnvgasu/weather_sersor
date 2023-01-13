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
import ru.edu.weather_sensor.dto.MeasurementAddRequestDTO;
import ru.edu.weather_sensor.dto.MeasurementAddResponseDTO;
import ru.edu.weather_sensor.model.Measurement;
import ru.edu.weather_sensor.service.MeasurementService;
import ru.edu.weather_sensor.util.MeasurementAddValidator;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController extends BaseController {

  private final MeasurementService service;

  private final ModelMapper modelMapper;

  private final MeasurementAddValidator addValidator;

  @Autowired
  public MeasurementController(MeasurementService service, ModelMapper modelMapper,
      MeasurementAddValidator addValidator) {
    this.service = service;
    this.modelMapper = modelMapper;
    this.addValidator = addValidator;
  }

  @PostMapping("/add")
  public ResponseEntity<MeasurementAddResponseDTO> add(
      @RequestBody @Valid MeasurementAddRequestDTO requestDTO, BindingResult bindingResult) {
    validate(addValidator, requestDTO, bindingResult);

    Measurement measurement = service.createFromDTO(requestDTO);
    MeasurementAddResponseDTO responseDTO = modelMapper.map(measurement, MeasurementAddResponseDTO.class);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

}
