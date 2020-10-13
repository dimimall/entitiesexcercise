package com.udacity.entitiesexcercise.Entities;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
//import javax.persistence.NamedQuery;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(name = "Delivery.findByName", query = "select d from Delivery d where d.name = :name")
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;
    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryTime;
    @Type(type = "yes_no")
    private Boolean completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
