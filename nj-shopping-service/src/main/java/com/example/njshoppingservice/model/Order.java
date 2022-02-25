package com.example.njshoppingservice.model;

public class Order {

    private int numOranges;
    private int numApples;

    public Order(int numOranges, int numApples) {
        this.numOranges = numOranges;
        this.numApples = numApples;
    }

    public int getNumOranges() {
        return numOranges;
    }

    public void setNumOranges(int numOranges) {
        this.numOranges = numOranges;
    }

    public int getNumApples() {
        return numApples;
    }

    public void setNumApples(int numApples) {
        this.numApples = numApples;
    }

    
}
