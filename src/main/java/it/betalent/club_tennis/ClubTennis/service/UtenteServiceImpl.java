package it.betalent.club_tennis.ClubTennis.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.betalent.club_tennis.ClubTennis.DTO.UtenteDTO;
import it.betalent.club_tennis.ClubTennis.DTO.UtenteDTOMapper;
import it.betalent.club_tennis.ClubTennis.entity.Utente;
import it.betalent.club_tennis.ClubTennis.repository.UtenteRepo;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	UtenteRepo utenteRepo;
	
	@Override
	public void creaUtente(UtenteDTO utenteDTO) {
		Utente utente = UtenteDTOMapper.DTOToUtente(utenteDTO);
		utente.setDataModifica(LocalDateTime.now());
		utenteRepo.save(utente);
	}
	
	@Override
	public UtenteDTO leggiUtente(Long id) {
		Optional<Utente> utente = utenteRepo.findById(id);
		if (utente.isEmpty()) {
			System.out.println("L'utente non esiste...");
		}
		UtenteDTO utenteDTO = UtenteDTOMapper.utenteToDTO(utente.get());
		return utenteDTO;
	}

	@Override
	public void modificaUtente(UtenteDTO utenteDTO) {
		Utente utente = UtenteDTOMapper.DTOToUtente(utenteDTO);
		utenteRepo.save(utente);
	}
	
	
	
}
