package com.learn.EMS.EMS.EmsDTO;

public class Expense {
    private long id;
    private String name;
    private double cost;
    private String type;
    public Expense(){

    }

    public Expense(long id, String name, double cost, String type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
