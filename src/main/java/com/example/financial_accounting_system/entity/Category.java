package com.example.financial_accounting_system.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Transaction> transactions=new ArrayList<>();

}