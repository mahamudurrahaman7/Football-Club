package com.realmadrid.service;

import com.realmadrid.model.TicketRequst;
import com.realmadrid.repository.TicketRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketRequestService {

    private final TicketRequestRepository ticketRequestRepository;

    public TicketRequestService(TicketRequestRepository ticketRequestRepository) {
        this.ticketRequestRepository = ticketRequestRepository;
    }

    //save
    public TicketRequst save(TicketRequst ticketRequst) {
        return ticketRequestRepository.save(ticketRequst);
    }
    public long totalTicketsSell(){
        return ticketRequestRepository.count();
    }
}
