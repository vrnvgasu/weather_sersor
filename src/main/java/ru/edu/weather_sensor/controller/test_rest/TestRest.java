package ru.edu.weather_sensor.controller.test_rest;

import java.util.Random;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import ru.edu.weather_sensor.dto.MeasurementAddRequestDTO;
import ru.edu.weather_sensor.dto.MeasurementAddResponseDTO;
import ru.edu.weather_sensor.dto.SensorRequestDTO;

public class TestRest {

  public TestRest() {
  }

  public static void main(String[] args) {
    Random random = new Random();
    RestTemplate restTemplate = new RestTemplate();

    System.out.println("Создаем данные");
    ModelMapper modelMapper = new ModelMapper();
    for (int i = 0; i < 1000; i++) {
      float value = random.nextFloat(100);
      value *= (random.nextBoolean() ? 1 : -1);
      MeasurementAddRequestDTO postRequestDTO = MeasurementAddRequestDTO.builder()
          .value(value)
          .raining(random.nextBoolean())
          .sensor(new SensorRequestDTO("1"))
          .build();
      HttpEntity<MeasurementAddRequestDTO> request = new HttpEntity<>(postRequestDTO);
      String url = "http://localhost:8080/api/measurements/add";
      String response = restTemplate.postForObject(url, request, String.class);
      MeasurementAddResponseDTO responseDTO = modelMapper.map(response, MeasurementAddResponseDTO.class);
      System.out.println("i=" + i + ": " + responseDTO.getValue());
    }

    String url = "http://localhost:8080/api/measurements";
    String response = restTemplate.getForObject(url, String.class);
    System.out.println(response);
  }

}
