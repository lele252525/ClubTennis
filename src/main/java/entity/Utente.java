package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "utente")
public class Utente extends BaseEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private int codice;
	
	private String nome;
	private String cognome;
	private int eta;
	
}
