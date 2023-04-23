package com.example.API.service;
import  com.example.API.entity.Client;

import java.util.List;

public interface ClientService {
    Client create(Client client);
    List<Client> voirClient();
    Client modifier(Integer id, Client client);
    String supprimer(Integer id);

}
