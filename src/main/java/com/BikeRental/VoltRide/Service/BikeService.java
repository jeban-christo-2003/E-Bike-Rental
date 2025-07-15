package com.BikeRental.VoltRide.Service;

import com.BikeRental.VoltRide.JPARepository;
import com.BikeRental.VoltRide.model.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    @Autowired
    JPARepository repository;

    public Boolean logincheck(model model) {
        model found = repository.findByUsernameAndPassword(
                model.getUsername(), model.getPassword());

        return found != null;
    }

    public String register(model modelObj) {
        repository.save(modelObj);
        return "success";
    }
}
