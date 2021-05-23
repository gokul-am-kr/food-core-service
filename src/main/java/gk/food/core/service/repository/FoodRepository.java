package gk.food.core.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gk.food.core.service.entity.FoodEntity;
import gk.food.core.service.utility.FoodCoreEnums;

/**
 * Repository interface for handle various DB operations related to Food entity.
 *
 */
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
	/**
	 * Method for search food based on criteria.
	 * 
	 * @param foodType Food Type VEG/NONVEG
	 * 
	 * @return List&lt;FoodEntity&gt; List of food entity.
	 */
	@Query("from FoodEntity where foodType=:foodType and quantity>0")
	public List<FoodEntity> searchFood(@Param("foodType") FoodCoreEnums.FoodType foodType);

	/**
	 * Method for fetch details of food entity.
	 * 
	 * @param foodId Food ID.
	 * 
	 * @return Food entity details.
	 */
	@Query("from FoodEntity where foodId=:foodId")
	public FoodEntity searchFoodDetails(@Param("foodId") String foodId);

	/**
	 * Method for fetch food details based on food IDs.
	 * 
	 * @param foodIds Food IDs
	 * 
	 * @return List&lt;FoodEntity&gt; List of food entity.
	 */
	@Query("from FoodEntity where foodId IN(:foodIds)")
	public List<FoodEntity> foodByIds(@Param("foodIds") List<String> foodIds);

	@Transactional
	@Modifying
	@Query("update FoodEntity set quantity=quantity-:qty where foodId=:foodId")
	public void updateProductQuantity(@Param("qty") int quantity, @Param("foodId") String foodIds);

}