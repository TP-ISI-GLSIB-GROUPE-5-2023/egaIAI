package com.example.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API.entity.Compte;

import java.util.Optional;

public interface CompteRepository  extends JpaRepository<Compte ,Integer> {

    Optional<Compte> findByNumerocompte(String numerocompte);
}
