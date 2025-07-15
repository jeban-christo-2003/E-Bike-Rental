package com.BikeRental.VoltRide;

import com.BikeRental.VoltRide.model.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends JpaRepository<model, Integer> {

    // Custom finder method for login check
    model findByUsernameAndPassword(String username, String password);

}
