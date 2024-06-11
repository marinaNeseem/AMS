package com.AMS.service;

import com.AMS.model.Auction;
import com.AMS.model.Bid;
import com.AMS.repository.AuctionRepository;
import com.AMS.repository.BidRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
@Slf4j
@Getter
@Setter
public class bidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;


    public Bid createBid(Long auctionId, Double bidPrice) {
        Optional<Auction> auctionOptional = auctionRepository.findById(auctionId);
        if (!auctionOptional.isPresent()) {
            return null;
        }
        List<Bid> existingBids = bidRepository.findFirstByAuctionOrderByBidPriceDesc(auctionOptional.get());
        if (!existingBids.isEmpty() && bidPrice <= existingBids.get(0).getBidPrice()) {
            return null;
        }
        Auction auction = auctionOptional.get();
        if (auction.getEnd_date().before(Calendar.getInstance(TimeZone.getDefault()).getTime())) {
            return null;
        }

        Bid bid = new Bid();
        bid.setAuction(auction);
        bid.setBidPrice(bidPrice);
        bid.setBid_datetime(Calendar.getInstance(TimeZone.getDefault()).getTime());
        bid.setBidder_status("ACTIVE");
        bid.setBidder_id(auction.getSeller().getUser_id()); // or set the ID of the user who is making the bid
        return bidRepository.save(bid);
    }


    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

}
