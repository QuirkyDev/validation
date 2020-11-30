package be.thomasmore.graduaten.voorbeeld.validation.service;

import be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker;

import java.util.List;

public interface GebruikerService {
    List<Gebruiker> getGebruikers();
    Gebruiker addGebruiker(Gebruiker gebruiker);
}
