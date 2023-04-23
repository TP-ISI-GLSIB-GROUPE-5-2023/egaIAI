package com.example.API.controller;



import com.example.API.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.API.entity.Client;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public Client creer(@RequestBody Client client){
        return clientService.create(client);
    }

    @GetMapping("/voirClient")
    public List<Client> voirClient(){
        return clientService.voirClient();
    }

    @PutMapping("/modifier/{id}")
    public Client modifier(@PathVariable Integer id,@RequestBody Client client){
        return clientService.modifier(id,client);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Integer id){
        return  clientService.supprimer(id);
    }



}
