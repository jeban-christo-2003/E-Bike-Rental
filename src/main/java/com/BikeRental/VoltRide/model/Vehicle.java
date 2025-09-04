package com.BikeRental.VoltRide.model;

public class Vehicle {
    private int id;
    private String name;
    private double lat; // must match "lat" in frontend
    private double lng; // must match "lng" in frontend

    // Default constructor (needed for JSON deserialization)
    public Vehicle() {
    }

    // Parameterized constructor
    public Vehicle(int id, String name, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
