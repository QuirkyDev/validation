package be.thomasmore.graduaten.voorbeeld.validation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gebruiker {

    public static final String VOORNAAM = "Voornaam";
    public static final String FAMILIENAAM = "Familienaam";
    public static final String EMAIL = "Email";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String voornaam;
    private String familienaam;
    private String email;

    public Gebruiker() {
    }

    public Gebruiker(String voornaam, String familienaam, String email) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
