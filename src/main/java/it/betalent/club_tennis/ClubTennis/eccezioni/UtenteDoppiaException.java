package it.betalent.club_tennis.ClubTennis.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UtenteDoppiaException extends RuntimeException {
	
	public UtenteDoppiaException(String message) {super(message);}

}
