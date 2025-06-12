package it.betalent.club_tennis.ClubTennis.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UtenteDTO {
	
	@Column(name = "idUtente")
	private Long id;
	
	@NotEmpty(message = "Il nome è un campo obbligatorio")
	@Size(min = 3, max = 30, message = "Il nome deve essere compreso tra 3 e 30 caratteri")
    private String nome;
	
	@NotEmpty(message = "Il cognome è un campo obbligatorio")
    @Size(min = 3, max = 15, message = "Il cognome deve essere compreso tra 3 e 15 caratteri")
    private String cognome;
	
	@NotNull(message = "L'età è un campo obbligatorio")
    @Min(3)
    private Integer eta;
	
}
