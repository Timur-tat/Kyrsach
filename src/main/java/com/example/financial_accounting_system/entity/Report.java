package com.example.financial_accounting_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Integer id;

    @Column(name = "end_date", nullable = false)
    private Long endDate;

    @Column(name = "generated_at")
    private Long generatedAt;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "start_date", nullable = false)
    private Long startDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generated_by")
    private User generatedBy;

}