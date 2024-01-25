package com.rimhassani.confirmerCommande.service;

import com.rimhassani.confirmerCommande.events.NewOrderEvent;
import com.rimhassani.confirmerCommande.model.ClientEntity;
import com.rimhassani.confirmerCommande.model.CommandeEntity;
import com.rimhassani.confirmerCommande.model.ProductEnitiy;
import com.rimhassani.confirmerCommande.repository.ClientRepository;
import com.rimhassani.confirmerCommande.repository.CommandeRepository;
import com.rimhassani.confirmerCommande.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;



    public CommandeEntity ajouterCommande(CommandeEntity nouvelleCommande) {


        CommandeEntity savedCommande = commandeRepository.save(nouvelleCommande);

        // Publiez l'événement de nouvelle commande
        eventPublisher.publishEvent(new NewOrderEvent(savedCommande));

        return savedCommande;
    }
    public List<CommandeEntity> getCommandes() {
        return commandeRepository.findAll();
    }
}
