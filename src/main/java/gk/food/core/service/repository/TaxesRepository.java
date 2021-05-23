package gk.food.core.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gk.food.core.service.entity.Taxes;

/**
 * Repository interface for handle various DB operations related to Taxes entity.
 *
 */
@Repository
public interface TaxesRepository extends JpaRepository<Taxes, Integer>{

}
