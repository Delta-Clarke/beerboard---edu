package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.User;
import fr.almeri.beerboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnexionController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/connexion")
    public String getConnexion(Model pModel){

        return "connexion";
    }
    @PostMapping("/loginOk")
    public String getLoginOk(Model pModel, @ModelAttribute User user) {
        User u = userRepository.getUser(user.getLogin(), user.getPassword());
        if (u != null) {
            return "redirect:/";
        } else {
            return "redirect:/connexion";
        }
    }

}

