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
import it.betalent.club_tennis.ClubTennis.costanti.TennisCostanti;
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
@RequestMapping (path=TennisCostanti.INGRESSO_END_POINT, produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class UtenteController {
	
	@Autowired
	UtenteService utenteService;
	@Autowired
	UtenteRepo utenteRepo;
	
	@PostMapping(TennisCostanti.CREA_END_POINT)
	public ResponseEntity<ResponseDTO> creaUtente (@Valid @RequestBody UtenteDTO utenteDTO) {	
		utenteService.creaUtente(utenteDTO);
		return ResponseEntity
				.status(HttpStatus.CREATED)
	            .body(new ResponseDTO(TennisCostanti.STATUS_201, TennisCostanti.STATUS_201_MESSAGE));
	}
	
	@GetMapping(TennisCostanti.LEGGI_END_POINT)
	public ResponseEntity<UtenteDTO> leggiUtente(@RequestParam Long id) {
		UtenteDTO utenteDTO = utenteService.leggiUtente(id);
		return ResponseEntity.status(HttpStatus.OK).body(utenteDTO);
	}
	
	@PutMapping(TennisCostanti.MODIFICA_END_POINT)
	public ResponseEntity<ResponseDTO> modificaUtente(@Valid @RequestBody UtenteDTO utenteDTO) {
        utenteService.modificaUtente(utenteDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(TennisCostanti.STATUS_200, TennisCostanti.STATUS_200_MESSAGE));
    }
	
	@DeleteMapping(TennisCostanti.CANCELLA_END_POINT)
	public ResponseEntity<ResponseDTO> cancellaUtente (@RequestParam Long id) {
		utenteService.cancellaUtente(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ResponseDTO(TennisCostanti.STATUS_200, TennisCostanti.STATUS_200_MESSAGE));
		}
	
}
