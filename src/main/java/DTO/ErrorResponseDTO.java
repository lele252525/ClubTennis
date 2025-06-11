package DTO;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponseDTO {
	
	private String apiPath;
	
	private HttpStatus errorCode;
	
	private  String errorMessage;

    private LocalDateTime errorTime;
	
}
