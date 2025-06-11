package service;

import DTO.UtenteDTO;

public interface UtenteService {
	
	public void creaUtente(UtenteDTO utenteDTO);
	public UtenteDTO leggiUtente(Long id);
	public void modificaUtente(UtenteDTO utenteDTO);
	
}
