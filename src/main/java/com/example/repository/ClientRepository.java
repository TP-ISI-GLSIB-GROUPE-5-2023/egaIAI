package com.example.API.repository;

import com.example.API.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client ,Integer> {
}
