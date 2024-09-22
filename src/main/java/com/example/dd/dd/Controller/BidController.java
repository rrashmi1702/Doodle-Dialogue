package com.example.dd.dd.Controller;
import com.example.dd.dd.Entities.Bid;
import com.example.dd.dd.Services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bids")
public class BidController {
    @Autowired
    private BidService bidService;

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @GetMapping("/{id}")
    public Optional<Bid> getBidById(@PathVariable Long id) {
        return bidService.getBidById(id);
    }

    @PostMapping
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.createBid(bid);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable Long id) {
        bidService.deleteBid(id);
    }
}
