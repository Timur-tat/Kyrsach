package com.example.financial_accounting_system.service;

import com.example.financial_accounting_system.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Account account) {
        entityManager.persist(account);
    }

    public Account findById(int id) {
        return entityManager.find(Account.class, id);
    }

    public List<Account> findAll() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    @Transactional
    public void update(Account account) {
        entityManager.merge(account);
    }

    @Transactional
    public void delete(int id) {
        Account account = findById(id);
        if (account != null) {
            entityManager.remove(account);
        }
    }
}