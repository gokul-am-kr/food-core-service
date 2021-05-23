package gk.food.core.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gk.food.core.service.entity.FoodPriceEntity;

/**
 * Repository interface for handle various DB operations related to Food price entity.
 *
 */
@Repository
public interface FoodPriceRepository extends JpaRepository<FoodPriceEntity, Integer>{
}