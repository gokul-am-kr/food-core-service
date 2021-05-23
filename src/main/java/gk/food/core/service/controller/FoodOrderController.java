package gk.food.core.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gk.food.core.service.business.FoodOrderService;
import gk.food.core.service.model.FoodOrderRequest;
import gk.food.core.service.model.FoodOrderResponse;

/**
 * Controller class related with food orders.
 *
 */
@RestController
@RequestMapping("/order")
public class FoodOrderController {

	/**
	 * Instance of FoodOrderService.
	 */
	@Autowired
	private FoodOrderService foodBookingService;

	/**
	 * Method for order food.
	 * 
	 * @param foodOrderRequest Food order request.
	 * 
	 * @return food order response
	 */
	@PostMapping("/orderfood")
	public FoodOrderResponse orderFood(@RequestBody FoodOrderRequest foodOrderRequest) {
		return foodBookingService.orderFood(foodOrderRequest);
	}
}