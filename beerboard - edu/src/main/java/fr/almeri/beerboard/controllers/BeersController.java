package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.Brasserie;
import fr.almeri.beerboard.repositories.BiereRepository;
import fr.almeri.beerboard.repositories.BrasserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
