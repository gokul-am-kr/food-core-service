package gk.food.food.core.service.processor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gk.food.core.service.entity.OrderEntity;
import gk.food.core.service.model.FoodOrderRequest;
import gk.food.core.service.repository.FoodOrderRepositoy;

/**
 * Class related with food order processing.
 *
 */
@Component
public class FoodOrderProcessor {

	/**
	 * Instance of FoodOrderRepositoy
	 */
	@Autowired
	private FoodOrderRepositoy foodOrderRepositoy;

	/**
	 * Method for insert order details to DB.
	 * 
	 * @param request Food order request.
	 * 
	 * @param foodIds List of food IDs
	 * 
	 * @return orderEntity Order entity.
	 */
	public OrderEntity insertOrderToDd(FoodOrderRequest request, String foodIds) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setFoodIds(foodIds);
		orderEntity.setOrderedDateTime(LocalDateTime.now());
		orderEntity.setUserId(request.getUserName());
		return foodOrderRepositoy.save(orderEntity);
	}
}