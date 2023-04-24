package com.example.API.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class transfertRequest {
    private String numerocompte;
    private String numerocomptemm;
    private String numerocomptdes;
    private double solde;
}
