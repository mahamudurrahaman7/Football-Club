package com.realmadrid.model;

import org.springframework.data.annotation.Id;

public class TicketRequst {
    @Id

    private String id;
    private User user;
    private UpcomingMatches matches;
    private int ticketAmount;
    private Ticket ticket;


    public TicketRequst() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UpcomingMatches getMatches() {
        return matches;
    }

    public void setMatches(UpcomingMatches matches) {
        this.matches = matches;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}
