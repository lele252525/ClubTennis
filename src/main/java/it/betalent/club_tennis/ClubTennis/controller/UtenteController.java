package it.betalent.club_tennis.ClubTennis.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.betalent.club_tennis.ClubTennis.DTO.UtenteDTO;
import it.betalent.club_tennis.ClubTennis.costanti.UtenteCostanti;
import it.betalent.club_tennis.ClubTennis.eccezioni.UtenteAssenteException;
import it.betalent.club_tennis.ClubTennis.eccezioni.UtenteDoppiaException;
import it.betalent.club_tennis.ClubTennis.entity.Utente;
import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import it.betalent.club_tennis.ClubTennis.repository.UtenteRepo;
import it.betalent.club_tennis.ClubTennis.service.UtenteService;
import it.betalent.club_tennis.ClubTennis.DTO.ResponseDTO;

@RestController
@RequestMapping (path="/gestione_utenti", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class UtenteController {
	
	@Autowired
	UtenteService utenteService;
	@Autowired
	UtenteRepo utenteRepo;
	
	@PostMapping("/creaUtente")
	public ResponseEntity<ResponseDTO> creaUtente (@Valid @RequestBody UtenteDTO utenteDTO) {
		if (utenteDTO.getId() != null) {
	        Optional<Utente> utenteOpzionale = utenteRepo.findById(utenteDTO.getId());
	        if (utenteOpzionale.isPresent()) {
	            throw new UtenteDoppiaException("L'Utente con ID " + utenteDTO.getId() + " è già stato registrato");
	        }
	    }	
		utenteService.creaUtente(utenteDTO);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
	            .body(new ResponseDTO(UtenteCostanti.STATUS_201, UtenteCostanti.STATUS_201_MESSAGE));
	}
	
	@GetMapping("/leggiUtente")
	public ResponseEntity<UtenteDTO> leggiUtente(@RequestParam Long id) {
		UtenteDTO utenteDTO = utenteService.leggiUtente(id);
		return ResponseEntity.status(HttpStatus.OK).body(utenteDTO);
	}
	
	@PutMapping("/modificaUtente")
	public ResponseEntity<ResponseDTO> modificaUtente(@Valid @RequestBody UtenteDTO utenteDTO) {
        Utente astronave = utenteRepo.findById(utenteDTO.getId()).orElseThrow(
                () -> new UtenteDoppiaException("La modifica non è autorizzata"));
        utenteService.modificaUtente(utenteDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(UtenteCostanti.STATUS_200, UtenteCostanti.STATUS_200_MESSAGE));
    }
	
	@DeleteMapping("/cancellaUtente")
	public ResponseEntity<ResponseDTO> cancellaUtente (@RequestParam Long id) {
		Utente utente = utenteRepo.findById(id).orElseThrow(
				() -> new UtenteAssenteException("L'Utente con ID " + id + " non esiste"));
		utenteRepo.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ResponseDTO(UtenteCostanti.STATUS_200, UtenteCostanti.STATUS_200_MESSAGE));
		}
	
}
