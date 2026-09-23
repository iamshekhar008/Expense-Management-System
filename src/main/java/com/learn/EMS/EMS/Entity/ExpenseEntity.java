package com.learn.EMS.EMS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private Double cost;   // renamed from "price", type changed to Double

    public ExpenseEntity(){}

    public ExpenseEntity(Long id, String name, String type, Double cost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setId(Long id) { this.id = id; }
    public void setCost(Double cost) { this.cost = cost; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public Double getCost() { return cost; }
}