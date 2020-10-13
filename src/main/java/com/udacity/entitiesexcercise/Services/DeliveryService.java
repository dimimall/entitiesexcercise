package com.udacity.entitiesexcercise.Services;

import com.udacity.entitiesexcercise.Entities.Delivery;
import com.udacity.entitiesexcercise.Entities.RecipientAndPrice;
import com.udacity.entitiesexcercise.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId)
    {
        return deliveryRepository.getPrice(deliveryId);
    }

    public Long save(Delivery delivery)
    {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }
}
