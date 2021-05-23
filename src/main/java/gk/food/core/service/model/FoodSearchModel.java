package gk.food.core.service.model;

import gk.food.core.service.utility.FoodCoreEnums.FoodType;
import lombok.Data;;

/**
 * Model class for food search opeartion.
 *
 */
@Data
public class FoodSearchModel {

	/**
	 * Food type.
	 */
	private FoodType foodType;

	/**
	 * Food ID.
	 */
	private String foodId;

}