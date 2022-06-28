package fr.almeri.beerboard.controllers;


import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.Brasserie;
import fr.almeri.beerboard.models.Region;
import fr.almeri.beerboard.repositories.BiereRepository;
import fr.almeri.beerboard.repositories.BrasserieRepository;
import fr.almeri.beerboard.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class BreweriesController {

    @Autowired
    private BrasserieRepository brasserieRepository;

    @Autowired
    private BiereRepository biereRepository;

    @Autowired
    private RegionRepository regionRepository;

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
    @GetMapping("/update-brewery/{code}")
    public String updateBrewery(Model pModel, @PathVariable(required = true) String code){
        //On récupére en bdd la brasserie dont l'ID (codeBrasserie) est = au code passé dans l'URL (http://localhost:8888/see-brewery/ache)
        Brasserie brasserie = brasserieRepository.findById(code).orElseThrow();
        // Permet d'envoyer les attribut récupéré en bdd pour l'envoyer sur le fichier HTML
        pModel.addAttribute("brasserieDetail", brasserie);

        ArrayList<Biere> listBiereFromDatabase = (ArrayList<Biere>) biereRepository.getMarqueVersionByCodeBrasserie(code);
        pModel.addAttribute("biereBrasserieDetail", listBiereFromDatabase);

        return "update-brewery";
    }

    @PostMapping("/update-brewery")
    public String updateBrewery(Model pModel, @ModelAttribute Brasserie brasserie, RedirectAttributes redirectAttributes){
            // Sinon On enregistre dans la BDD
            brasserieRepository.save(brasserie);
            // Envoie d'un message de succées
            redirectAttributes.addFlashAttribute("messageSucces", "La brasserie a bien été modifiée.");
            // Redirige vers la liste des brasseries
            return "redirect:/breweries";
        }

    @GetMapping("/delete-brewery/{code}")
    public String deleteBrewery(Model pModel, @PathVariable(required = true) String code){
        //On récupére en bdd la brasserie dont l'ID (codeBrasserie) est = au code passé dans l'URL (http://localhost:8888/see-brewery/ache)
        Brasserie brasserie = brasserieRepository.findById(code).orElseThrow();
        // Permet d'envoyer les attribut récupéré en bdd pour l'envoyer sur le fichier HTML
        pModel.addAttribute("brasserieDetail", brasserie);

        ArrayList<Biere> listBiereFromDatabase = (ArrayList<Biere>) biereRepository.getMarqueVersionByCodeBrasserie(code);
        pModel.addAttribute("biereBrasserieDetail", listBiereFromDatabase);

        return "delete-brewery";
    }

    @PostMapping("/delete-brewery")
    public String deleteBrewery(Model pModel, @ModelAttribute Brasserie brasserie, RedirectAttributes redirectAttributes){
        // Sinon On enregistre dans la BDD
        brasserieRepository.deleteById((brasserie.getCodeBrasserie()));
        // Envoie d'un message de succées
        redirectAttributes.addFlashAttribute("messageSucces", "La brasserie a bien été supprimée.");
        // Redirige vers la liste des brasseries
        return "redirect:/breweries";
    }


    @GetMapping("/add-brewery")
    public String setBrewery(Model pModel){
        //On récupére en bdd la brasserie dont l'ID (codeBrasserie) est = au code passé dans l'URL (http://localhost:8888/see-brewery/ache)
//        Brasserie brasserie = brasserieRepository.findById(code).orElseThrow();
        // Permet d'envoyer les attribut récupéré en bdd pour l'envoyer sur le fichier HTML
//        pModel.addAttribute("brasserieDetail", brasserie);
        ArrayList<Region> listRegionFromDatabase = (ArrayList<Region>) regionRepository.findAll();
        pModel.addAttribute("listRegion", listRegionFromDatabase);
        return "add-brewery";
    }
    @PostMapping("/add-brewery")
    public String addBrewery(Model pModel, @ModelAttribute Brasserie brasserie, RedirectAttributes redirectAttributes){
        // On vérifie si l'identifiant existe
        if (brasserieRepository.existsById(brasserie.getCodeBrasserie())){
            // S'il existe, on renvoie un message d'erreur.
            redirectAttributes.addFlashAttribute("messageErreur", "L'identifiant existe déjà.");
            // On redirige vers le formulaire d'ajout
            return "redirect:/add-brewery";
        }else {
            // Sinon On enregistre dans la BDD
            brasserieRepository.save(brasserie);
            // Envoie d'un message de succées
            redirectAttributes.addFlashAttribute("messageSucces", "La brasserie a bien été enregistrée.");
            // Redirige vers la liste des brasseries
            return "redirect:/breweries";
        }
    }

}
