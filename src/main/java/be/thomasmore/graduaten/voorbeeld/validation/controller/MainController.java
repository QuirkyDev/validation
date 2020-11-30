package be.thomasmore.graduaten.voorbeeld.validation.controller;

import be.thomasmore.graduaten.voorbeeld.validation.model.Gebruiker;
import be.thomasmore.graduaten.voorbeeld.validation.service.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, String> errors = new HashMap<>();
        values.put(Gebruiker.VOORNAAM, "");
        values.put(Gebruiker.FAMILIENAAM, "");
        values.put(Gebruiker.EMAIL, "");
        model.addAttribute("values", values);
        model.addAttribute("errors", errors);
        return "form";
    }

    @RequestMapping("/overview")
    public String navigateOverview(Model model) {
        model.addAttribute("gebruikers", service.getGebruikers());
        return "overview";
    }

    @RequestMapping("/process-form")
    public String processForm(HttpServletRequest request, Model model) {
        //Initializing maps of values and errors
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, String> errors = new HashMap<>();

        //Validate value of voornaam
        String voornaam = request.getParameter(Gebruiker.VOORNAAM);
        values.put(Gebruiker.VOORNAAM, voornaam);
        if (voornaam.isEmpty()) {
            errors.put(Gebruiker.VOORNAAM, "U moet een voornaam invullen!");
        }

        //Validate value of familienaam
        String familienaam = request.getParameter(Gebruiker.FAMILIENAAM);
        values.put(Gebruiker.FAMILIENAAM, familienaam);
        if (familienaam.isEmpty()) {
            errors.put(Gebruiker.FAMILIENAAM, "U moet een familienaam invullen!");
        }

        //Validate value of email
        String email = request.getParameter(Gebruiker.EMAIL);
        values.put(Gebruiker.EMAIL, email);

        int posAt = email.indexOf("@");
        int posDot = (posAt != -1) ? email.substring(posAt).indexOf(".") : -1;
        if (email.isEmpty()) {
            errors.put(Gebruiker.EMAIL, "U moet een email invullen!");
        } else if (posAt == -1 || posDot == -1 || posDot > posAt) {
            errors.put(Gebruiker.EMAIL, "Deze email is niet geldig!");
        }

        //Navigate to correct page with correct actions
        if (errors.isEmpty()) {
            service.addGebruiker(new Gebruiker(voornaam, familienaam, email));
            return "index";
        } else {
            model.addAttribute("values", values);
            model.addAttribute("errors", errors);
            return "form";
        }
    }
}
