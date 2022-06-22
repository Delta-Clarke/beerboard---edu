package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.repositories.BiereRepository;
import fr.almeri.beerboard.repositories.BrasserieRepository;
import fr.almeri.beerboard.repositories.PaysRepository;
import fr.almeri.beerboard.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Controller
public class IndexController {

    @Autowired
    private PaysRepository paysRepository;

    @Autowired
    private BiereRepository biereRepository;

    @Autowired
    private BrasserieRepository brasserieRepository;

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/")
    public String home(Model pModel, HttpSession pSession){
        pModel.addAttribute("bieres", 328);
        pModel.addAttribute("brasseries", 99);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        pModel.addAttribute("updated", dtf.format(LocalDateTime.now()));

        //répartition des brasserie par région
        ArrayList<String> labelsPieChart = regionRepository.getNomRegionAsc();
        ArrayList<String> datasPieChart = regionRepository.getNbRegion();
        pModel.addAttribute("labelsPieChart", labelsPieChart);
        pModel.addAttribute("datasPieChart", datasPieChart);

        //Nombre de bières par taux alcool
        ArrayList<String> labelsAreaChart = biereRepository.getTauxAlcool();
        ArrayList<Double> datasAreaChart = biereRepository.getTauxAlcoolGroup();
        pModel.addAttribute("labelsAreaChart", labelsAreaChart);
        pModel.addAttribute("datasAreaChart", datasAreaChart );

        //Consomation & production de bière par pays
        ArrayList<String> labelsBarChart = paysRepository.getNomPaysAsc();
        ArrayList<Double> datasConsommation = paysRepository.getConsoPays();
        ArrayList<Double> datasProduction = paysRepository.getProdPays();
        pModel.addAttribute("labelsBarChart", labelsBarChart);
        pModel.addAttribute("datasConsommation", datasConsommation);
        pModel.addAttribute("datasProduction", datasProduction);

        //Nombre de marque référencé par brasserie
        ArrayList<String> labelsBarChart1 = brasserieRepository.getNomBrasserieAsc();
        ArrayList<String> datasBarChart1 = brasserieRepository.getNbMarque();
        pModel.addAttribute("labelsBarChart1", labelsBarChart1);
        pModel.addAttribute("datasBarChart1", datasBarChart1);

        //Nombre de versions par marque
        ArrayList<String> labelsBarChart2 = (ArrayList<String>) biereRepository.getNomBiere();
        ArrayList<Integer> datasBarChart2 = biereRepository.getNbVersion();
        pModel.addAttribute("labelsBarChart2", labelsBarChart2);
        pModel.addAttribute("datasBarChart2", datasBarChart2);

        return "index";
    }

    @GetMapping("/logout")
    public String logout(Model pModel, RedirectAttributes pRedirectAttributes, HttpSession pSession){
        return "redirect:/";
    }
}
