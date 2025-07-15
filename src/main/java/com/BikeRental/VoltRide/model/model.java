package com.BikeRental.VoltRide.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class model {

    @Id
    private int id;
    private String username;

    private String password;


    public int Getid(){
        return id;
    }
    public int setid(int id){
        return this.id=id;
    }
    public String Getusername(){
        return username;
    }
    // Getters and Setters (or use Lombok with @Getter/@Setter)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
