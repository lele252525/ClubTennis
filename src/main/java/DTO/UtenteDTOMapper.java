package DTO;

import entity.Utente;

public class UtenteDTOMapper {
	
	public static UtenteDTO utenteToDTO (Utente utente, UtenteDTO utenteDTO) {
		utenteDTO.setId(utente.getId());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setEta(utente.getEta());
		return utenteDTO;
	}
	
	public static Utente DTOToUtente (Utente utente, UtenteDTO utenteDTO) {
		utente.setId(utenteDTO.getId());
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		utente.setEta(utenteDTO.getEta());
		return utente;
	}
	
}
