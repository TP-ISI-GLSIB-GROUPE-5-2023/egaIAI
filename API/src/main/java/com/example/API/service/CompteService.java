package com.example.API.service;

import com.example.API.entity.Compte;

import java.util.List;

public interface CompteService {
    Compte create(Compte client);
    List<Compte> voirCompte();
    Compte modifier(Integer id, Compte compte);
    String supprimer(Integer id);
    Compte depot(String numerocompte, double solde);
    Compte retrait(String numerocompte, double solde);
    String transfert(String numerocomptemm , String numerocomptdes, double solde);



}
