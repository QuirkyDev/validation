package be.thomasmore.graduaten.voorbeeld.validation.repository;

import be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends JpaRepository<Gebruiker, Long> {
}
