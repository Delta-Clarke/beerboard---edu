package fr.almeri.beerboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnexionController {

    @GetMapping("/connexion")
    public String getConnexion(Model pModel){

        return "connexion";
    }
}

