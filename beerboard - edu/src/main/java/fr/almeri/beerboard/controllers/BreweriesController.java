package fr.almeri.beerboard.controllers;


import fr.almeri.beerboard.models.Brasserie;
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


    @GetMapping("/breweries")
    public String getListBreweries(Model pModel){
        pModel.addAttribute("prenom", "Léo DAUBORD");

        ArrayList<Brasserie> listBrasserieFromDatabase = (ArrayList<Brasserie>) brasserieRepository.findAll();
        pModel.addAttribute("listBrasserie", listBrasserieFromDatabase);

        return "breweries";
    }

    @GetMapping("/see-brewery/{code}")
    public String getBrewery(Model pModel, @PathVariable(required = true) String code){
        Brasserie brasserie = brasserieRepository.findById(code).orElseThrow();
        return "brewery";
    }

    @GetMapping("/see-brewery1")
    public String getBreweryByCode(Model pModel, @RequestParam(required = true) String code, @RequestParam(required = false) String toto){
        return "brewery";
    }
}
