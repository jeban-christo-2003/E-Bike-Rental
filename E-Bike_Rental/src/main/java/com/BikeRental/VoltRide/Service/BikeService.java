package com.BikeRental.VoltRide.Service;

import com.BikeRental.VoltRide.JPARepository;
import com.BikeRental.VoltRide.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;



@Service
public class BikeService {

    @Autowired
    private JPARepository repository;

    public boolean logincheck(Model model) {
        if (model == null || model.getUsername() == null || model.getPassword() == null) {
            return false;
        }
        Model found = repository.findByUsernameAndPassword(model.getUsername(), model.getPassword());
        return found != null;
    }


    public boolean register(Model modelObj) {
        if (modelObj == null || modelObj.getUsername() == null || modelObj.getPassword() == null) {
            throw new IllegalArgumentException("username and password must be provided");
        }

        if (repository.existsByUsername(modelObj.getUsername())) {
            throw new DataIntegrityViolationException("username-already-exists");
        }
        repository.save(modelObj);
        return true;
    }
}
