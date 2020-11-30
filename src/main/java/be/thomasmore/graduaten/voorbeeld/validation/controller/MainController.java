package be.thomasmore.graduaten.voorbeeld.validation.controller;

import be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker;
import be.thomasmore.graduaten.voorbeeld.validation.model.GebruikerError;
import be.thomasmore.graduaten.voorbeeld.validation.service.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    GebruikerService service;

    @RequestMapping("/")
    public String navigateHome() {
        return "index";
    }

    @RequestMapping("/form")
    public String navigateForm(Model model) {
        Gebruiker gebruiker = new Gebruiker();
        GebruikerError gebruikerError = new GebruikerError();
        model.addAttribute(Gebruiker.NAME, gebruiker);
        model.addAttribute(GebruikerError.NAME, gebruikerError);
        return "form";
    }

    @RequestMapping("/overview")
    public String navigateOverview(Model model) {
        model.addAttribute("gebruikers", service.getGebruikers());
        return "overview";
    }

    @RequestMapping("/process-form")
    public String processForm(HttpServletRequest request, Model model) {
        //Inizializing gebruiker and gebruikerError objects
        Gebruiker gebruiker = new Gebruiker();
        GebruikerError gebruikerError = new GebruikerError();

        //Validate value of voornaam
        String voornaam = request.getParameter(Gebruiker.VOORNAAM);
        gebruiker.setVoornaam(voornaam);
        if (voornaam.isEmpty()) {
            gebruikerError.voornaam = "U moet een voornaam invullen!";
            gebruikerError.hasErrors = true;
        }

        //Validate value of familienaam
        String familienaam = request.getParameter(Gebruiker.FAMILIENAAM);
        gebruiker.setFamilienaam(familienaam);
        if (familienaam.isEmpty()) {
            gebruikerError.familienaam = "U moet een familienaam invullen!";
            gebruikerError.hasErrors = true;
        }

        //Validate value of email
        String email = request.getParameter(Gebruiker.EMAIL);
        gebruiker.setEmail(email);

        int posAt = email.indexOf("@");
        int posDot = (posAt != -1) ? email.substring(posAt).indexOf(".") : -1;
        if (email.isEmpty()) {
            gebruikerError.email = "U moet een email invullen!";
            gebruikerError.hasErrors = true;
        } else if (posAt == -1 || posDot == -1 || posDot > posAt) {
            gebruikerError.email = "Deze email is niet geldig!";
            gebruikerError.hasErrors = true;
        }

        //Navigate to correct page with correct actions
        if (gebruikerError.hasErrors) {
            model.addAttribute(Gebruiker.NAME, gebruiker);
            model.addAttribute(GebruikerError.NAME, gebruikerError);
            return "form";
        } else {
            service.addGebruiker(gebruiker);
            model.addAttribute("gebruikers", service.getGebruikers());
            return "overview";
        }
    }
}
