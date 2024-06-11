package com.AMS.service;

import com.AMS.model.Auction;
import com.AMS.repository.AuctionRepository;
import com.AMS.repository.BidRepository;
import com.AMS.repository.userRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Getter
@Setter
public class SellerService {
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private userRepository usersRepository;

    public void addAuctions(Auction newAuction) {
        auctionRepository.save(newAuction);
    }
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(Long id) {
        Optional<Auction> auction = auctionRepository.findById(id);
        return auction.orElse(null);
    }
    /*public  List<Auction> getAuctionseller(long seller){
        return auctionRepository.findBySellerid(seller);
    }*/

    public void deleteAuctionById(Long id) {
        auctionRepository.deleteById(id);
    }

    public Auction saveAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public void updateAuction(Auction newAuction) {
        auctionRepository.save(newAuction);
    }

}