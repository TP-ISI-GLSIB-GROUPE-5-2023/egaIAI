package com.example.API.service;
import com.example.API.entity.Compte;
import com.example.API.repository.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompteServiceImpl implements  CompteService{

    @Autowired
    private final CompteRepository compteRepository;

    @Override
    public Compte create(Compte compte){
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> voirCompte() {
        return compteRepository.findAll();
    }

     public Compte modifier(Integer Numcompte, Compte compte){
        return compteRepository.findById(Numcompte)
                .map(co->{
                    co.setDatecreation(compte.getDatecreation());
                    co.setSolde(compte.getSolde());
                    co.setTypeCompte(compte.getTypeCompte());
                    co.setProprietaire(compte.getProprietaire());
                    co.setNumerocompte(compte.getNumerocompte());
                    return compteRepository.save(co);
                }) .orElseThrow(()-> new RuntimeException("Compte non trouve "));
     }

    @Override
    public String supprimer(Integer Numcompte){
        compteRepository.deleteById(Numcompte);
        return "Compte supprime";
    }
    @Override
    public Compte depot(String numerocompte, double solde){
        Optional<Compte> compt = compteRepository.findByNumerocompte(numerocompte);
        if(compt.isPresent()){
            compt.get().setSolde(compt.get().getSolde() + solde);
            compteRepository.save(compt.get());
        }
        return compt.get();
    }
    @Override
    public Compte retrait(String numerocompte ,double solde){
        Optional<Compte> compt = compteRepository.findByNumerocompte(numerocompte);
        if(compt.isPresent()){
            compt.get().setSolde(compt.get().getSolde()-solde);
            compteRepository.save(compt.get());
        }
        return compt.get();
    }
    @Override
    public String transfert(String numerocomptemm ,String numerocomptdes , double solde){
        retrait(numerocomptemm,solde);
        depot(numerocomptdes,solde);
        return "transfert fait avec succes";
    }
}
