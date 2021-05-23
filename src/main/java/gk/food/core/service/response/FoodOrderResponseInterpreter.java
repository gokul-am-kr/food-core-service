package gk.food.core.service.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gk.food.core.service.entity.FoodEntity;
import gk.food.core.service.model.FoodOrderModel;
import gk.food.core.service.model.FoodOrderRequest;
import gk.food.core.service.model.FoodOrderResponse;

/**
 * Class for interpret food order response from DB data.
 *
 */
@Component
public class FoodOrderResponseInterpreter {

	/**
	 * Method for build order response.
	 * 
	 * @param foodEntityList   Food entity list.
	 * 
	 * @param foodOrderRequest FOod order request.
	 * 
	 * @param response         Response of order.
	 */
	public void buildOrderResponse(List<FoodEntity> foodEntityList, FoodOrderRequest foodOrderRequest,
	        FoodOrderResponse response) {
		response.setLocalDateTime(LocalDateTime.now().plusHours(1));
		response.setDeliveryAgent("Arun");
		List<FoodOrderModel> foodOrderList = new ArrayList<>();
		foodEntityList.stream().forEach(foodEntity -> {
			int quantity = foodOrderRequest.getFoodOrderList().stream()
			        .filter(request -> request.getFoodId().equals(foodEntity.getFoodId())).findFirst().get()
			        .getQuantity();
			FoodOrderModel foodOrderModel = buildFoodDetails(foodEntity, response, quantity);
			foodOrderList.add(foodOrderModel);
		});
		response.setOrderedFood(foodOrderList);
		response.setUsername(foodOrderRequest.getUserName());
		response.setCurrencyCode("INR");
		response.setTotalPrice(foodOrderList.stream().mapToLong(order -> order.getTotalPrice()).sum());
	}

	/**
	 * Method for build order details.
	 * 
	 * @param foodEntity Food entity.
	 * 
	 * @param response   Response.
	 * 
	 * @param quantity   Quantity.
	 * 
	 * @return foodOrderModel Food order model.
	 */
	private FoodOrderModel buildFoodDetails(FoodEntity foodEntity, FoodOrderResponse response, int quantity) {
		FoodOrderModel foodOrderModel = new FoodOrderModel();
		foodOrderModel.setFoodId(foodEntity.getFoodId());
		foodOrderModel.setQuantity(quantity);
		foodOrderModel.setTotalPrice(quantity * foodEntity.getFoodPrice().getFoodTotalPrice());
		foodOrderModel.setCurrencyCode("INR");
		return foodOrderModel;
	}
}