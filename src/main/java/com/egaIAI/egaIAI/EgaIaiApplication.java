package com.egaIAI.egaIAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EgaIaiApplication {

	public static void main(String[] args) {

		SpringApplication.run(EgaIaiApplication.class, args);

		Compte compte = new Compte();
		compte.setNumeroCompte("ABC123");
		compte.setTypeCompte(TypeCompte.EPARGNE);
		compte.setDateCreation(LocalDate.now());
		compte.setSolde(0.0);
		compte.setProprietaire(client);

		entityManager.persist(compte);

	}

}



