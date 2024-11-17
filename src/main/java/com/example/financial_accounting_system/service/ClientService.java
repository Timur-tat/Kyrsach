package com.example.financial_accounting_system.service;

import com.example.financial_accounting_system.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Client client) {
        entityManager.persist(client);
    }

    public Client findById(int id) {
        return entityManager.find(Client.class, id);
    }

    public List<Client> findAll() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    @Transactional
    public void update(Client client) {
        entityManager.merge(client);
    }

    @Transactional
    public void delete(int id) {
        Client client = findById(id);
        if (client != null) {
            entityManager.remove(client);
        }
    }
}