package com.udacity.entitiesexcercise.Controllers;

import com.udacity.entitiesexcercise.Entities.Delivery;
import com.udacity.entitiesexcercise.Entities.RecipientAndPrice;
import com.udacity.entitiesexcercise.Services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery){
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId)
    {
        return deliveryService.getBill(deliveryId);
    }
}
