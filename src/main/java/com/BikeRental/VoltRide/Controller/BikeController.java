package com.BikeRental.VoltRide.Controller;

import com.BikeRental.VoltRide.Service.BikeService;
import com.BikeRental.VoltRide.model.Model;
import com.BikeRental.VoltRide.model.Vehicle;
import com.BikeRental.VoltRide.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BikeController {
    @Autowired
    private BikeService service;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String index() {
        return "BikeRental";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Model modelObj) {
        try {
            boolean ok = service.logincheck(modelObj);
            if (ok) {
                String token = jwtUtil.generateToken(modelObj.getUsername());
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "token", token,
                        "message", "BikeRental authenticated successfully"
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("success", false, "message", "Authentication failed"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "Server error: " + e.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Model modelObj) {
        try {
            service.register(modelObj);
            return ResponseEntity.ok(Map.of("success", true, "message", "User registered successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "Registration failed: " + e.getMessage()));
        }
    }

    @GetMapping("/vehicles")
    public List<Vehicle> vehicleList() {
        return List.of(
                new Vehicle(1, "E-Volt-Bike", 8.8050, 78.1510),
                new Vehicle(2, "EcoRider", 8.7642, 78.1348),
                new Vehicle(3, "VoltRacer", 8.8027, 78.1519)
        );
    }
}
