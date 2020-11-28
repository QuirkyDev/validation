package be.thomasmore.graduaten.voorbeeld.validation.service;

import be.thomasmore.graduaten.voorbeeld.validation.entity.Gebruiker;

import java.util.List;

public interface GebruikerService {
    List<Gebruiker> getGebruikers();
    Gebruiker addGebruiker(Gebruiker gebruiker);
}
