package com.udacity.entitiesexcercise.Repository;

import com.udacity.entitiesexcercise.Entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {

    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delevered);

    @Query("select p.delivery.completed from Plant p where p.id=:plantId")
    Boolean deliveryCompleted(Long plantId);

    @Query("select new java.lang.Boolean(p.delivery.completed) from Plant p where p.id = :plantId")
    Boolean deliveryCompletedBoolean(Long plantId);

    List<Plant> findByPriceLessThan(BigDecimal price);
}
