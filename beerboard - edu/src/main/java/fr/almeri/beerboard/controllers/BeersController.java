package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.BiereId;
import fr.almeri.beerboard.models.Brasserie;
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
        Biere biere = biereRepository.findById(new BiereId(marque, version)).orElseThrow();
        pModel.addAttribute("biere", biere);
        return "beer";
    }
}
