package com.AMS.controller;
import com.AMS.model.Auction;
import com.AMS.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/seller/sells")
public class SellerController {
@Autowired
    private  SellerService SellerService;

    @PostMapping("/addAuctions")
    public ResponseEntity<Auction> addAuctions ( @RequestBody Auction newAuction) {

        SellerService.addAuctions(newAuction);

        return new ResponseEntity<Auction> (newAuction , HttpStatus.OK);

    }
    @GetMapping("/getAllAuctions")
    public List<Auction>  getAllAuctions () {

        return SellerService.getAllAuctions();
    }

    @GetMapping("/Auction/{id}")
    public ResponseEntity<Auction> getAuctionById(@PathVariable ("id") Long id)
    {
        Auction auction = SellerService.getAuctionById(id);

        if(auction != null){
            return new ResponseEntity<>(auction , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    /*@GetMapping("/auctions/{seller}/seller")
    public List<Auction> getAuctionseller(@PathVariable long seller){
        return SellerService.getAuctionseller(seller);
    }*/

    @DeleteMapping("/deleteAuction")
    public String deleteAuction (@RequestParam long id) {
        SellerService.deleteAuctionById(id);
        return "Delete Successfully";
    }
    @PutMapping("/updateAuction")
    public ResponseEntity<Auction> updateAuction( @RequestBody Auction updatedAuction) {

        SellerService.updateAuction(updatedAuction);

        return new ResponseEntity<Auction> (updatedAuction , HttpStatus.OK) ;

    }

}