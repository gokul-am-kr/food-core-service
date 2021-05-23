package gk.food.core.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gk.food.core.service.entity.OrderEntity;

/**
 * Repository interface for handle various DB operations related to Order entity.
 *
 */
@Repository
public interface FoodOrderRepositoy extends JpaRepository<OrderEntity, Integer>{

}
