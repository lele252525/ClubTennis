package it.betalent.club_tennis.ClubTennis.DTO;

import it.betalent.club_tennis.ClubTennis.entity.Utente;

public class UtenteDTOMapper {
	
	public static UtenteDTO utenteToDTO (Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setId(utente.getId());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setEta(utente.getEta());
		return utenteDTO;
	}
	
	public static Utente DTOToUtente (UtenteDTO utenteDTO) {
		Utente utente = new Utente();
		utente.setId(utenteDTO.getId());
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		utente.setEta(utenteDTO.getEta());
		return utente;
	}
	
}
