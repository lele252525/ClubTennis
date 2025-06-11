package DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UtenteDTO {
	
	private Long id;
	
	@NotEmpty(message = "Il nome è un campo obbligatorio")
	@Size(min = 3, max = 30, message = "Il nome deve essere compreso tra 3 e 30 caratteri")
    private String nome;
	
	@NotEmpty(message = "Il cognome è un campo obbligatorio")
    @Size(min = 3, max = 15, message = "Il cognome deve essere compreso tra 3 e 15 caratteri")
    private String cognome;
	
	@NotEmpty(message = "L'età è un campo obbligatorio")
    @Size(min = 3, message = "L'utente deve avere almeno 3 anni")
    private int eta;
	
}
