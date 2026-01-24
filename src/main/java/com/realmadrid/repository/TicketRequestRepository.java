package com.realmadrid.repository;


import com.realmadrid.model.TicketRequst;
import com.realmadrid.model.UpcomingMatches;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TicketRequestRepository extends MongoRepository<TicketRequst, String> {




}
