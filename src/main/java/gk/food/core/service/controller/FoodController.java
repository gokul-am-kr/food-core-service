package gk.food.core.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gk.food.core.service.business.FoodSearchService;
import gk.food.core.service.entity.FoodEntity;
import gk.food.core.service.model.FoodSearchModel;

/**
 * Controller class for handle various food core services
 *
 */
@RestController
@RequestMapping("/search")
public class FoodController {

	/**
	 * Bean creation for food search service.
	 */
	@Autowired
	private FoodSearchService foodSearchService;

	/**
	 * Method for list all the foods in table.
	 * 
	 * @return List&lt;FoodEntity&gt; List for food entity.
	 */
	@GetMapping("/allfood")
	public List<FoodEntity> searchAllFood() {
		return foodSearchService.searchAllfood();
	}
	
	/**
	 * Method for search food based on criteria.
	 * 
	 * @param foodSearchModel Food search model.
	 * 
	 * @return List&lt;FoodEntity&gt; List for food entity.
	 */
	@PostMapping("/searchfood")
	public List<FoodEntity> searchFood(@RequestBody FoodSearchModel foodSearchModel){
		return foodSearchService.searchFood(foodSearchModel);
	}
	
	/**
	 * Method for search food based on criteria.
	 * 
	 * @param foodSearchModel Food search model.
	 * 
	 * @return List&lt;FoodEntity&gt; List for food entity.
	 */
	@PostMapping("/searchfooddetails")
	public FoodEntity searchFoodDetails(@RequestBody FoodSearchModel foodSearchModel){
		return foodSearchService.searchFoodDetails(foodSearchModel);
	}
}