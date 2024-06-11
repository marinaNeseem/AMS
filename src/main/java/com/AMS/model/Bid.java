package com.AMS.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid_id;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private Auction auction;

    private Double bidPrice;

    private Date bid_datetime;

    private String bidder_status;

    private Long bidder_id;
}
