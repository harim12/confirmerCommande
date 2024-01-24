package com.rimhassani.confirmerCommande.repository;

import com.rimhassani.confirmerCommande.model.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity,Long> {
}
