package fr.almeri.beerboard.controllers;


import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

//Permet d'indiquer à Spring Boot qu'il y aura un "routage" dans ce fichier
@Controller
public class ExampleController {


    @Autowired
    private PaysRepository paysRepository;

    @Autowired
    private BrasserieRepository brasserieRepository;

    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private RegionRepository regionRepository;



    //Permet de définir une route appelée avec la méthode GET ("directement via l'URL")
    //Ici localhost:8888/example
    @GetMapping("/example")
    public String getPageExample(Model pModel){
        pModel.addAttribute("prenom", "Leo");

        Pays pays = new Pays();
        pays.setNomPays("France");
        pays.setConsomation(145.0);
        pays.setProduction(190.9);

        Pays pays1 = new Pays();
        pays1.setNomPays("Allemagne");
        pays1.setConsomation(265.7);
        pays1.setProduction(456.9);

        Pays pays2 = new Pays();
        pays2.setNomPays("Angleterre");
        pays2.setConsomation(132.3);
        pays2.setProduction(98.7);

        ArrayList<Pays> listPays = new ArrayList<>();
        listPays.add(pays);
        listPays.add(pays1);
        listPays.add(pays2);

        pModel.addAttribute("pays", pays);

        ArrayList<Pays> listPaysFromDatabase = (ArrayList<Pays>) paysRepository.findAll();
        pModel.addAttribute("listPays", listPaysFromDatabase);

        ArrayList<Brasserie> listBrasserieFromDatabase = (ArrayList<Brasserie>) brasserieRepository.findAll();
        pModel.addAttribute("listBrasserie", listBrasserieFromDatabase);

        ArrayList<Marque> listMarqueFromDatabase = (ArrayList<Marque>) marqueRepository.findAll();
        pModel.addAttribute("listMarque", listMarqueFromDatabase);

        ArrayList<Type> listTypeFromDatabase = (ArrayList<Type>) typeRepository.findAll();
        pModel.addAttribute("listType", listTypeFromDatabase);

        ArrayList<Region> listRegionFromDatabase = (ArrayList<Region>) regionRepository.findAll();
        pModel.addAttribute("listRegion", listRegionFromDatabase);


        //Méthode permettant d'indiquer quelle page HTML on renvoie
        return "Example";
    }
}
