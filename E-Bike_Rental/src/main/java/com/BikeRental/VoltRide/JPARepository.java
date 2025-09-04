package com.BikeRental.VoltRide;

import com.BikeRental.VoltRide.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends JpaRepository<Model, Integer> {
    Model findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
