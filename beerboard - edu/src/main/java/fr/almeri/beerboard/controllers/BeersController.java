package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.BiereRepository;
import fr.almeri.beerboard.repositories.MarqueRepository;
import fr.almeri.beerboard.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class BeersController {

    @Autowired
    private BiereRepository biereRepository;

    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private TypeRepository typeRepository;

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

    @GetMapping("/update-beer/{marque}")
    public String updateBeer(Model pModel, @PathVariable(required = true) String marque, @RequestParam(required = true) String version){
        //On récupére en bdd la brasserie dont l'ID (codeBrasserie) est = au code passé dans l'URL (http://localhost:8888/see-brewery/ache)
        Biere biere = biereRepository.findById(new BiereId(marque, version)).orElseThrow();
        // Permet d'envoyer les attribut récupéré en bdd pour l'envoyer sur le fichier HTML
        pModel.addAttribute("biere", biere);
//        ArrayList<Biere> listBiereFromDatabase = (ArrayList<Biere>) biereRepository.getMarqueVersionByCodeBrasserie(code);
//        pModel.addAttribute("biereBrasserieDetail", listBiereFromDatabase);

        return "update-beer";
    }

    @PostMapping("/update-beer")
    public String updateBeer(Model pModel, @ModelAttribute Biere biere, RedirectAttributes redirectAttributes){
        // Sinon On enregistre dans la BDD
        biereRepository.save(biere);
        // Envoie d'un message de succées
        redirectAttributes.addFlashAttribute("messageSucces", "La bière a bien été modifiée.");
        // Redirige vers la liste des brasseries
        return "redirect:/beers";
    }

    @GetMapping("/delete-beer/{marque}")
    public String deleteBeer(Model pModel, @PathVariable(required = true) String marque, @RequestParam(required = true) String version, RedirectAttributes redirectAttributes){
        // Supprime de la BDD
        biereRepository.deleteById(new BiereId(marque, version));
        // Envoie d'un message de succées
        redirectAttributes.addFlashAttribute("messageSucces", "La bière a bien été supprimée.");
        // Redirige vers la liste des brasseries
        return "redirect:/beers";
    }

    @GetMapping("/add-beer")
    public String setBrewery(Model pModel){
        ArrayList<Marque> listMarqueFromDatabase = (ArrayList<Marque>) marqueRepository.findAll();
        pModel.addAttribute("listNomMarque", listMarqueFromDatabase);
        ArrayList<Type> listTypeFromDatabase = (ArrayList<Type>) typeRepository.findAll();
        pModel.addAttribute("listNoType", listTypeFromDatabase);
        return "add-beer";
    }
    @PostMapping("/add-beer")
    public String addBeer(Model pModel, @ModelAttribute Biere biere, RedirectAttributes redirectAttributes){
        // On vérifie si l'identifiant existe
        if (biereRepository.existsById(new BiereId(biere.getMarque().getNomMarque(), biere.getVersion()))){
            // S'il existe, on renvoie un message d'erreur.
            redirectAttributes.addFlashAttribute("messageErreur", "L'identifiant existe déjà.");
            // On redirige vers le formulaire d'ajout
            return "redirect:/add-beer";
        }else {
            // Sinon On enregistre dans la BDD
            biereRepository.save(biere);
            // Envoie d'un message de succées
            redirectAttributes.addFlashAttribute("messageSucces", "La biere a bien été enregistrée.");
            // Redirige vers la liste des brasseries
            return "redirect:/beers";
        }
    }
}
