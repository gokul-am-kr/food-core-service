package gk.food.core.service.model;

import java.util.List;

import lombok.Data;

/**
 * Model class for making food order request.
 *
 */
@Data
public class FoodOrderRequest {

	/**
	 * Food order list
	 */
	private List<FoodOrderModel> foodOrderList;
	
	/**
	 * User name
	 */
	private String userName;
	
	/**
	 * Password
	 */
	private String passWord;
	
	/**
	 * Coupon code
	 */
	private String couponCode;
}