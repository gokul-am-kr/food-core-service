package gk.food.core.service.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gk.food.core.service.entity.FoodEntity;
import gk.food.core.service.model.FoodSearchModel;
import gk.food.core.service.repository.FoodRepository;
import gk.food.core.service.utility.FoodCoreEnums.FoodType;

/**
 * Service class for food search related operations.
 *
 */
@Service
public class FoodSearchService {

	/**
	 * Instance of FoodRepository
	 */
	@Autowired
	private FoodRepository foodRepository;

	/**
	 * Method for fetch all food details from DB.
	 * 
	 * @return List&lt;FoodEntity&gt; List of food entity.
	 */
	public List<FoodEntity> searchAllfood() {

		return foodRepository.findAll();
	}

	/**
	 * Method for search food items.
	 * 
	 * @param foodSearchModel Food search model.
	 * 
	 * @return List&gt;FoodEnt&gt;List of food entities.
	 */
	public List<FoodEntity> searchFood(FoodSearchModel foodSearchModel) {
		List<FoodEntity> foodList = new ArrayList<>();
		if (foodSearchModel.getFoodType() == null || foodSearchModel.getFoodType() == FoodType.ALL) {
			foodList = foodRepository.findAll();
		} else {
			foodList = foodRepository.searchFood(foodSearchModel.getFoodType());
		}
		return foodList;
	}

	/**
	 * Method for search food item details.
	 * 
	 * @param foodSearchModel Food search model.
	 * 
	 * @return Food entity.
	 */
	public FoodEntity searchFoodDetails(FoodSearchModel foodSearchModel) {
		return foodRepository.searchFoodDetails(foodSearchModel.getFoodId());
	}
}