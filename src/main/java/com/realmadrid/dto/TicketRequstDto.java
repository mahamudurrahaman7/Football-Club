package com.realmadrid.dto;

import com.realmadrid.model.UpcomingMatches;
import com.realmadrid.model.User;

public class TicketRequstDto {
//    private User user;

    private int ticketAmount;
    private boolean success;

    public TicketRequstDto() {
    }



    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
