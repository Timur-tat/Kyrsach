package com.example.financial_accounting_system.service;

import com.example.financial_accounting_system.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Transaction transaction) {
        entityManager.merge(transaction);
    }

    public Transaction findById(int id) {
        return entityManager.find(Transaction.class, id);
    }

    public List<Transaction> findAll() {
        return entityManager.createQuery("SELECT t FROM Transaction t", Transaction.class).getResultList();
    }

    @Transactional
    public void update(Transaction transaction) {
        entityManager.merge(transaction);
    }

    @Transactional
    public void delete(int id) {
        Transaction transaction = findById(id);
        if (transaction != null) {
            entityManager.remove(transaction);
        }
    }
}