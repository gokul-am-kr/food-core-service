package gk.food.core.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gk.food.core.service.entity.Tax;

/**
 * Repository interface for handle various DB operations related to tax entity.
 *
 */
@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer>{

}
