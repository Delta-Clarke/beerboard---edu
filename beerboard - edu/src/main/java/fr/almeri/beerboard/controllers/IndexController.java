package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.repositories.PaysRepository;
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

    @GetMapping("/")
    public String home(Model pModel, HttpSession pSession){
        pModel.addAttribute("bieres", 328);
        pModel.addAttribute("brasseries", 99);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        pModel.addAttribute("updated", dtf.format(LocalDateTime.now()));

        //répartition des brasserie par région
        ArrayList<String> labelsPieChart = new ArrayList<>();
        labelsPieChart.add("Label 1");
        labelsPieChart.add("Label 2");
        pModel.addAttribute("labelsPieChart", labelsPieChart);
        pModel.addAttribute("datasPieChart", new int[]{2,9});

        //Nombre de bières par taux alcool
        pModel.addAttribute("labelsAreaChart", new String[]{"2.6", "5", "7.5"});
        pModel.addAttribute("datasAreaChart", new int[]{1,50,15});

        //Consomation & production de bière par pays
        ArrayList<String> labelsBarChart = paysRepository.getNomPaysAsc();
        ArrayList<Double> datasConsommation = paysRepository.getConsoPays();
        ArrayList<Double> datasProduction = paysRepository.getProdPays();
        pModel.addAttribute("labelsBarChart", labelsBarChart);
        pModel.addAttribute("datasConsommation", datasConsommation);
        pModel.addAttribute("datasProduction", datasProduction);

        //Nombre de marque référencé par brasserie
        pModel.addAttribute("labelsBarChart1", new String[]{"Brasserie 1", "Brasserie 2"});
        pModel.addAttribute("datasBarChart1", new int[]{5,2});

        //Nombre de versions par marque
        ArrayList<String> labelsBarChart2 = new ArrayList<>();
        labelsBarChart2.add("Marque 1");
        labelsBarChart2.add("Marque 2");
        pModel.addAttribute("labelsBarChart2", labelsBarChart2);
        pModel.addAttribute("datasBarChart2", new int[]{1,4});

        return "index";
    }

    @GetMapping("/logout")
    public String logout(Model pModel, RedirectAttributes pRedirectAttributes, HttpSession pSession){
        return "redirect:/";
    }
}
