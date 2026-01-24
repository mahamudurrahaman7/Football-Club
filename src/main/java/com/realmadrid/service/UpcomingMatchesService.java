package com.realmadrid.service;

import com.realmadrid.model.Ticket;
import com.realmadrid.model.UpcomingMatches;

import com.realmadrid.repository.UpcomingMatchesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UpcomingMatchesService {
    private final UpcomingMatchesRepository upcomingMatchesRepository;


    public UpcomingMatchesService(UpcomingMatchesRepository upcomingMatchesRepository) {
        this.upcomingMatchesRepository = upcomingMatchesRepository;
    }

    //Save fixure
    public UpcomingMatches save(UpcomingMatches match){
        return upcomingMatchesRepository.save(match);
    }

    //delete fixure
    public void deleteWithId(String id){
        upcomingMatchesRepository.deleteById(id);
    }

    //Get All
    public List<UpcomingMatches> findAll(){
        return upcomingMatchesRepository.findAll();



    }

    //get by id
    public UpcomingMatches findById(String id){
        return upcomingMatchesRepository.findById(id).get();
    }


    //update available ticket....... available ticket komaitee hbeeeeeeeeeeee....


    public boolean updateAvailableTicket(UpcomingMatches match,String ticketType ,int ticketSelled){
        Optional<UpcomingMatches> optional = upcomingMatchesRepository.findById(match.getId());


        if (optional.isPresent()) {
            UpcomingMatches upcomingMatches = optional.get();

            for (Ticket ticket : upcomingMatches.getTickets()) {
                if (ticket.getTicketType().equals(ticketType)) {

                    if (ticket.getAvailableQuantity() >= ticketSelled) {  // ticket available ache kina
                        ticket.setAvailableQuantity(ticket.getAvailableQuantity() - ticketSelled);
                        upcomingMatchesRepository.save(upcomingMatches);
                        return true;
                    } else {
                        System.out.println("Not enough available quantity");
                        return false;
                    }
                }
                else{
                    System.out.println("ticket type not found.");
                    return false;
                }
            }
        }
        System.out.println("match is not present.");
        return false;


    }
    //get a ticket of a matches.....
    public Ticket getSingleTicket(UpcomingMatches match,String ticketType){
        Optional<UpcomingMatches> optional = upcomingMatchesRepository.findById(match.getId());


        if (optional.isPresent()) {
            UpcomingMatches upcomingMatches = optional.get();

            for (Ticket ticket : upcomingMatches.getTickets()) {
                if (ticket.getTicketType().equals(ticketType)) {

                    return ticket;
                }
                else{
                    return null;
                }
            }
        }
        return null;


    }
    public List<Ticket> getAvailableTickets(UpcomingMatches match){
        return upcomingMatchesRepository.findById(match.getId()).get().getTickets();

    }


}
