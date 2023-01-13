package ru.edu.weather_sensor.exception;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.edu.weather_sensor.dto.ErrorResponseDTO;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	private static final String INVALID_REQUEST_PARAMETERS_MESSAGE = "Invalid request parameters: ";


	@ExceptionHandler(value = {
			ValidationException.class
	})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponseDTO> handleInvalidRequestParamsException(RuntimeException e) {
		ErrorResponseDTO responseDTO = new ErrorResponseDTO(e.getMessage());
		return ResponseEntity.badRequest().body(responseDTO);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponseDTO> handleInvalidRequestParamsException(MethodArgumentNotValidException e) {
		ErrorResponseDTO responseDTO = new ErrorResponseDTO(
				INVALID_REQUEST_PARAMETERS_MESSAGE +
						Objects.requireNonNull(e.getFieldError()).getDefaultMessage()
		);
		return ResponseEntity.badRequest().body(responseDTO);
	}

}
