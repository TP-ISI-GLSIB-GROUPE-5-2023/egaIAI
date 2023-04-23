package com.example.API.controller;

import com.example.API.entity.Compte;
import com.example.API.requests.compteRequest;
import com.example.API.requests.transfertRequest;
import com.example.API.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/compte")
@AllArgsConstructor
public class CompteController {
    private final CompteService compteService;

    @PostMapping("/create")
    public Compte creer(@RequestBody Compte compte){
        return compteService.create(compte);
    }

    @GetMapping("/voirCompte")
    public List<Compte> voircompte(){
        return compteService.voirCompte();
    }

    @PutMapping("/modifier/{id}")
    public Compte modifier(@PathVariable Integer Numcompte, @RequestBody Compte compte){
        return compteService.modifier(Numcompte,compte);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Integer Numcompte){
        return  compteService.supprimer(Numcompte);
    }

    @PostMapping("/depot")
    public Compte depot(@RequestBody compteRequest compte ){
        return compteService.depot(compte.getNumerocompte(), compte.getSolde());
    }

    @PostMapping("/retrait")
    public Compte retrait(@RequestBody compteRequest compte ){
        return compteService.retrait(compte.getNumerocompte(), compte.getSolde());
    }
    @PostMapping("/transfert")
    public String transfert(@RequestBody transfertRequest info){
        return compteService.transfert(info.getNumerocomptemm(),info.getNumerocomptdes(),info.getSolde());
    }



}
