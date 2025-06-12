package it.betalent.club_tennis.ClubTennis.service;

import it.betalent.club_tennis.ClubTennis.DTO.UtenteDTO;

public interface UtenteService {
	
	public void creaUtente(UtenteDTO utenteDTO);
	public UtenteDTO leggiUtente(Long id);
	public void modificaUtente(UtenteDTO utenteDTO);
	
}
