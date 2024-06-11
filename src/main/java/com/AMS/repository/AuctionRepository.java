package com.AMS.repository;

import com.AMS.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    //public List<Auction> findBySellerid(long seller);
}
