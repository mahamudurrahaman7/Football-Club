package com.realmadrid.model;

import org.springframework.data.annotation.Id;

public class Ticket {

    @Id
    private String id;
    private String ticketType;  // Example: VIP, Standard, Early Bird
    private double price;
    private int availableQuantity;

    public Ticket() {}

    public Ticket(String ticketType, double price, int availableQuantity) {
        this.ticketType = ticketType;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String type) {
        this.ticketType = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }


}
