package com.udacity.entitiesexcercise.Services;

import com.udacity.entitiesexcercise.Entities.Plant;
import com.udacity.entitiesexcercise.Repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        return new Plant();
    }

    public Long save(Plant plant)
    {
        return plantRepository.save(plant).getId();
    }

    public Boolean delivered(Long id)
    {
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id,true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price)
    {
        return plantRepository.findByPriceLessThan(price);
    }
}
