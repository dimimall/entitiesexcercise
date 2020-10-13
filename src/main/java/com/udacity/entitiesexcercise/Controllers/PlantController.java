package com.udacity.entitiesexcercise.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.entitiesexcercise.Entities.Plant;
import com.udacity.entitiesexcercise.PlantDTO;
import com.udacity.entitiesexcercise.Services.PlantService;
import com.udacity.entitiesexcercise.Views;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        return convertPlantToPlantDTO(plant);
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant,plantDTO);
        return plantDTO;
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id)
    {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price)
    {
        return plantService.findPlantsBelowPrice(price);
    }
}