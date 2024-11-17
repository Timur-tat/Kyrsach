package com.example.financial_accounting_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", nullable = false)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "name")
    private String name;

}