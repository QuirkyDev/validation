package be.thomasmore.graduaten.voorbeeld.validation.service;

import be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker;
import be.thomasmore.graduaten.voorbeeld.validation.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GebruikerServiceImpl implements GebruikerService {

    @Autowired
    GebruikerRepository repository;

    @Override
    public List<Gebruiker> getGebruikers() {
        return repository.findAll();
    }

    @Override
    public Gebruiker addGebruiker(Gebruiker gebruiker) {
        return repository.save(gebruiker);
    }
}
