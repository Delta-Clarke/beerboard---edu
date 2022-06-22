package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.BiereId;
import fr.almeri.beerboard.repositories.BiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class BeersController {

    @Autowired
    private BiereRepository biereRepository;


    @GetMapping("/beers")
    public String getListBeers(Model pModel){
        pModel.addAttribute("prenom", "Leo");

        ArrayList<Biere> listBiereFromDatabase = (ArrayList<Biere>) biereRepository.findAll();
        pModel.addAttribute("listBiere", listBiereFromDatabase);

        return "beers";
    }


    @GetMapping("/see-beer")// /see-beer?marque={marque}&version={version}
    public String getBeersByCode(Model pModel, @RequestParam(required = true) String marque, @RequestParam(required = true) String version){
        //On récupére en bdd la biere dont l'ID (IdBiere) est = au code passé dans l'URL (http://localhost:8888/see-beer)
        Biere biere = biereRepository.findById(new BiereId(marque, version)).orElseThrow();
        // Permet d'envoyer les attribut récupéré en bdd pour l'envoyer sur le fichier HTML
        pModel.addAttribute("biere", biere);
        return "see-beer";
    }
}
