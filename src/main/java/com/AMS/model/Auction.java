package com.AMS.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;



@Entity
@Data
public class Auction{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String auction_name;
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(nullable = false)
	private Users seller;

	// @Column(name = "start_date")
	private Date start_date;

	//@Column(name = "start_date")
	private Date end_date;
}
