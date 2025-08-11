package com.BikeRental.VoltRide.Controller;

import com.BikeRental.VoltRide.Service.BikeService;
import com.BikeRental.VoltRide.model.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeController {
@Autowired
BikeService service;

@GetMapping("/")
public String index() {
    return "BikeRental";
}
    @PostMapping("/login")
    public String login(@RequestBody model modelObj) {
      boolean value=  service.logincheck(modelObj);
        if(value){

            return "BikeRental authenticated successfully";
        }
        else{
            return "BikeRental authentication failed";
        }
    }
    @PostMapping("/Register")
    public String register(@RequestBody model modelObj) {
   String value= service.register(modelObj);
   return value;
    }


}
