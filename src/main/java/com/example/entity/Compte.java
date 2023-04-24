package com.example.API.entity;


import com.example.API.enums.TypeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Compte")

public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Numcompte;
    @Column(nullable = false)
    private Date datecreation;
    @Column(nullable = false)
    private Double solde;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

    @ManyToOne
    @JoinColumn(name="Client_id")
    private Client proprietaire;

    @Column(nullable = false)
    private String numerocompte;

    @PrePersist
    private void initialAttribut() {
        if (solde == null) {
            solde = 0.0;
        }
        if (numerocompte == null) {
            numerocompte = generateAccountNumber();
        }
        if (datecreation == null) {
            datecreation = new Date();
        }
    }
    private String generateAccountNumber() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        // Générer cinq lettres aléatoires
        for (int i = 0; i < 5; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        return sb.toString() + year;
    }




}


