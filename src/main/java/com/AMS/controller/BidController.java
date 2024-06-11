package com.AMS.controller;

import com.AMS.model.Auction;
import com.AMS.model.Bid;
import com.AMS.service.bidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bidder/bids")
public class BidController {

    @Autowired
    private bidService BidService;


    @PostMapping("/{auctionId}/{bidPrice}")
    public ResponseEntity<String> createBid(@PathVariable Long auctionId, @PathVariable Double bidPrice) {
        Bid bid = BidService.createBid(auctionId, bidPrice);
        if (bid == null) {
            return ResponseEntity.badRequest().body("Failed to create bid");
        } else {
            return ResponseEntity.ok("Bid Added successfully");
        }
    }



    @GetMapping("/getAllBids")
    public List<Bid> getAllBids () {

        return BidService.getAllBids();
    }
}
