package com.example.financial_accounting_system.service;

import com.example.financial_accounting_system.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Category category) {
        entityManager.merge(category);
    }

    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @Transactional
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Transactional
    public void delete(int id) {
        Category category = findById(id);
        if (category != null) {
            entityManager.remove(category);
        }
    }
}