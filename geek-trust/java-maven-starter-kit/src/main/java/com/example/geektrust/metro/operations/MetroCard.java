package com.example.geektrust.metro.operations;

/**
 * ashwrai
 * 11-12-2022
 **/
public class MetroCard {

    private String name;
    private int balance;
    private Station lastStation;

    public MetroCard(String name, int balance)
    {
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }

    public void addBalance(int money)
    {
        balance = balance + money;
    }

    public void deduct(int charges) {
        this.balance = balance - charges;
    }

    public Station getLastStation() {
        return lastStation;
    }

    public void setLastStation(Station lastStation) {
        this.lastStation = lastStation;
    }
}
