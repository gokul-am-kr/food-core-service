package gk.food.core.service.model;

import lombok.Data;

/**
 * Model class related with food ordering.
 *
 */
@Data
public class FoodOrderModel {

	/**
	 * Food ID
	 */
	private String foodId;

	/**
	 * Quantity
	 */
	private Integer quantity;

	/**
	 * TOtal price
	 */
	private Long totalPrice;

	/**
	 * Currency code
	 */
	private String currencyCode;
}