package com.example.API.service;
import com.example.API.entity.Client;
import com.example.API.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class ClientServiceImpl implements ClientService{

    @Autowired
    private final ClientRepository clientRepository;

    @Override
    public Client create(Client client){
        return clientRepository.save(client);
    }

    @Override
    public List<Client> voirClient(){
        return clientRepository.findAll();
    }

    @Override
    public Client modifier(Integer id ,Client client){
        return clientRepository.findById(id)
                .map(c ->{
                    c.setNom(client.getNom());
                    c.setPrenom(client.getPrenom());
                    c.setDnaiss(client.getDnaiss());
                    c.setSexe(client.getSexe());
                    c.setAdresse(client.getAdresse());
                    c.setNumtel(client.getNumtel());
                    c.setCourriel(client.getCourriel());
                    c.setNationalite(client.getNationalite());
                    return clientRepository.save(c);
        }) .orElseThrow(()-> new RuntimeException("Client non trouve "));
    }


    @Override
    public String supprimer(Integer id){
        clientRepository.deleteById(id);
        return "Client supprime";
    }


}
