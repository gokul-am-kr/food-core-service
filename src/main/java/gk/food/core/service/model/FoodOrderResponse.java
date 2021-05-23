package gk.food.core.service.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

/**
 * Model class for food order response.
 *
 */
@Data
public class FoodOrderResponse {
	
	/**
	 * Order ID
	 */
	private String orderId;
	
	/**
	 * Ordered food list
	 */
	private List<FoodOrderModel> orderedFood;
	
	/**
	 * Total price
	 */
	private Long totalPrice;
	
	/**
	 * Currency code
	 */
	private String currencyCode;
	
	/**
	 * User name
	 */
	private String username;
	
	/**
	 * Delivery agent
	 */
	private String deliveryAgent;
	
	/**
	 * Local date time
	 */
	private LocalDateTime localDateTime;
	
	/**
	 * Message
	 */
	private Message message;
}