package com.example.dd.dd.Services;

import com.example.dd.dd.Entities.Bid;
import com.example.dd.dd.Repositories.BidRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class BidService {
    private static final Logger logger = LoggerFactory.getLogger(BidService.class);

    @Autowired
    private BidRepository bidRepository;

    public List<Bid> getAllBids() {
        logger.info("Fetching all bids");
        return bidRepository.findAll();
    }

    public Optional<Bid> getBidById(Long id) {
        logger.info("Fetching bid with id: {}", id);
        return bidRepository.findById(id);
    }

    @Transactional
    public Bid createBid(Bid bid) {
        logger.info("Creating bid: {}", bid);
        return bidRepository.save(bid);
    }

    @Transactional
    public void deleteBid(Long id) {
        logger.info("Deleting bid with id: {}", id);
        bidRepository.deleteById(id);
    }

//    @Transactional
//    public Bid updateBid(Long id, Bid updatedBid) {
//        Optional<Bid> existingBidOptional = bidRepository.findById(id);
//
//        if (existingBidOptional.isPresent()) {
//            Bid existingBid = existingBidOptional.get();
//
//            // Update the fields with the new data
//            existingBid.setAmount(updatedBid.getAmount()); // Use appropriate setter
//            existingBid.setDescription(updatedBid.getDescription()); // Use appropriate setter
//            // Add other fields as necessary
//
//            // Save and return the updated bid
//            return bidRepository.save(existingBid);
//        } else {
//            throw new EntityNotFoundException("Bid not found with id: " + id);
//        }
//    }
}
