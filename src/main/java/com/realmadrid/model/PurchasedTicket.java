package com.realmadrid.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class PurchasedTicket {
    @Id
    private String id;
    @DBRef
    private UpcomingMatches upcomingMatches;
    private int ticketBuyQuantity;


    public PurchasedTicket() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UpcomingMatches getUpcomingMatches() {
        return upcomingMatches;
    }

    public void setUpcomingMatches(UpcomingMatches upcomingMatches) {
        this.upcomingMatches = upcomingMatches;
    }

    public int getTicketBuyQuantity() {
        return ticketBuyQuantity;
    }

    public void setTicketBuyQuantity(int ticketBuyQuantity) {
        this.ticketBuyQuantity = ticketBuyQuantity;
    }
}
