package gk.food.core.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gk.food.core.service.entity.PriceEntity;

/**
 * Repository interface for handle various DB operations related to Price entity.
 *
 */
@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer>{

}
