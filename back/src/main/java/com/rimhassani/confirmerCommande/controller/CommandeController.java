package com.rimhassani.confirmerCommande.controller;


import com.rimhassani.confirmerCommande.model.CommandeEntity;
import com.rimhassani.confirmerCommande.model.ProductEnitiy;
import com.rimhassani.confirmerCommande.repository.CommandeRepository;
import com.rimhassani.confirmerCommande.repository.ProductRepository;
import com.rimhassani.confirmerCommande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;


    @GetMapping("/")
    public ResponseEntity<List<CommandeEntity>> getCommandes() {
        List<CommandeEntity> commandes = commandeService.getCommandes();

        if (commandes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(commandes, HttpStatus.OK);
        }
    }


    @PostMapping("/ajouter")
    public CommandeEntity ajouterCommande(@RequestBody CommandeEntity nouvelleCommande) {
        return commandeService.ajouterCommande(nouvelleCommande);
    }



}
