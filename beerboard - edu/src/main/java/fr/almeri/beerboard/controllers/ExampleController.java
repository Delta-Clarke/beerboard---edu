package fr.almeri.beerboard.controllers;


import fr.almeri.beerboard.models.Pays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

//Permet d'indiquer à Spring Boot qu'il y aura un "routage" dans ce fichier
@Controller
public class ExampleController {

    //Permet de définir une route appelée avec la méthode GET ("directement via l'URL")
    //Ici localhost:8888/example
    @GetMapping("/example")
    public String getPageExample(Model pModel){
        pModel.addAttribute("prenom", "Marie");

        Pays pays = new Pays();
        pays.setNomPays("France");
        pays.setConsomation(145.0);
        pays.setProduction(190.9);

        Pays pays1 = new Pays();
        pays.setNomPays("Allemagne");
        pays.setConsomation(265.7);
        pays.setProduction(456.9);

        Pays pays2 = new Pays();
        pays.setNomPays("Angleterre");
        pays.setConsomation(132.3);
        pays.setProduction(98.7);

        ArrayList<Pays> listPays = new ArrayList<>();
        listPays.add(pays);
        listPays.add(pays1);
        listPays.add(pays2);

        pModel.addAttribute("pays", pays);
        pModel.addAttribute("listPays", listPays);

        //Méthode permettant d'indiquer quelle page HTML on renvoie
        return "Example";
    }
}
