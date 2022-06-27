package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.BiereRepository;
import fr.almeri.beerboard.repositories.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class BeersController {

    @Autowired
    private BiereRepository biereRepository;

    @Autowired
    private MarqueRepository marqueRepository;

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
    @GetMapping("/add-beer")
    public String setBrewery(Model pModel){
        ArrayList<Marque> listMarqueFromDatabase = (ArrayList<Marque>) marqueRepository.findAll();
        pModel.addAttribute("listMarque", listMarqueFromDatabase);
        return "add-beer";
    }
    @PostMapping("/add-brewery")
    public String addBeer(Model pModel, @ModelAttribute Biere biere, RedirectAttributes redirectAttributes){
        // On vérifie si l'identifiant existe
        if (biereRepository.existsById(marque.getNomMarque())){
            // S'il existe, on renvoie un message d'erreur.
            redirectAttributes.addFlashAttribute("messageErreur", "L'identifiant existe déjà.");
            // On redirige vers le formulaire d'ajout
            return "redirect:/add-brewery";
        }else {
            // Sinon On enregistre dans la BDD
            biereRepository.save(biere);
            // Envoie d'un message de succées
            redirectAttributes.addFlashAttribute("messageSucces", "La brasserie a bien été enregistrée.");
            // Redirige vers la liste des brasseries
            return "redirect:/beers";
        }
    }
}
