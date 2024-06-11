package com.AMS.controller;
import com.AMS.Dto.*;
import com.AMS.model.Auction;
import com.AMS.service.SellerService;
import com.AMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsersControllers {
   @Autowired
    private UserService userService;

    @PostMapping("/Register")
    public String Register(@RequestBody UserDto newUser) {
        userService.Register(newUser);
        return "Register Successfully!!";

    }

    @PostMapping("/Login")
    public String Login(@RequestBody LoginDto loginDTO) {
        return userService.loginUser(loginDTO);

    }

}