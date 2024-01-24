package com.rimhassani.confirmerCommande.repository;

import com.rimhassani.confirmerCommande.model.ProductEnitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEnitiy,Long> {
}
