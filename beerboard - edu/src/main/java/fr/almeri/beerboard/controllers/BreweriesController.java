package fr.almeri.beerboard.controllers;


import fr.almeri.beerboard.models.Brasserie;
import fr.almeri.beerboard.repositories.BrasserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BreweriesController {

    @Autowired
    private BrasserieRepository brasserieRepository;


    @GetMapping("/breweries")
    public String getListBreweries(Model pModel){
        pModel.addAttribute("prenom", "Leo");


        ArrayList<Brasserie> listBrasserieFromDatabase = (ArrayList<Brasserie>) brasserieRepository.findAll();
        pModel.addAttribute("listBrasserie", listBrasserieFromDatabase);



        return "breweries";



    }

}