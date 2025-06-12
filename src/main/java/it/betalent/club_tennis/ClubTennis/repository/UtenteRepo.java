package it.betalent.club_tennis.ClubTennis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import it.betalent.club_tennis.ClubTennis.entity.Utente;
import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface UtenteRepo extends JpaRepository<Utente, Long> {
	
	public Optional<Utente> findById (Long id);
	
	@Transactional
	public void deleteById (Long id);
	
}
