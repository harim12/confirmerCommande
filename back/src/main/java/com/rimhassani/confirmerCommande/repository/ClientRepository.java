package com.rimhassani.confirmerCommande.repository;

import com.rimhassani.confirmerCommande.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<ClientEntity,Long> {
}
