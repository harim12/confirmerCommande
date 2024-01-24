package com.rimhassani.confirmerCommande.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dateCommande;


   private String productName;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "client_id")
   private ClientEntity client;


    private Long totalPrice;
}
