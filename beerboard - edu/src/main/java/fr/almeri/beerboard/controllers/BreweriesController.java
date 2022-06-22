package fr.almeri.beerboard.controllers;


import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.Brasserie;
import fr.almeri.beerboard.models.Region;
import fr.almeri.beerboard.repositories.BiereRepository;
import fr.almeri.beerboard.repositories.BrasserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class BreweriesController {

    @Autowired
    private BrasserieRepository brasserieRepository;

    @Autowired
    private BiereRepository biereRepository;

    @GetMapping("/breweries")
    public String getListBreweries(Model pModel){
        pModel.addAttribute("prenom", "Léo DAUBORD");

        ArrayList<Brasserie> listBrasserieFromDatabase = (ArrayList<Brasserie>) brasserieRepository.findAll();
        pModel.addAttribute("listBrasserie", listBrasserieFromDatabase);

        return "breweries";
    }

    @GetMapping("/see-brewery/{code}")
    public String getBrewery(Model pModel, @PathVariable(required = true) String code){
        //On récupére en bdd la brasserie dont l'ID (codeBrasserie) est = au code passé dans l'URL (http://localhost:8888/see-brewery/ache)
        Brasserie brasserie = brasserieRepository.findById(code).orElseThrow();
        // Permet d'envoyer les attribut récupéré en bdd pour l'envoyer sur le fichier HTML
          pModel.addAttribute("brasserieDetail", brasserie);

          ArrayList<Biere> listBiereFromDatabase = (ArrayList<Biere>) biereRepository.getMarqueVersionByCodeBrasserie(code);
        pModel.addAttribute("biereBrasserieDetail", listBiereFromDatabase);


        return "see-brewery";
    }
}
