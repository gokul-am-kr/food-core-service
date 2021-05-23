package gk.food.core.service.model;

import gk.food.core.service.utility.FoodCoreEnums;
import lombok.Data;

/**
 * Message model
 *
 */
@Data
public class Message {

	/**
	 * Message Text
	 */
	private String message;

	/**
	 * Message type
	 */
	private FoodCoreEnums.MessageType messageType;
	
	/**
	 * Message ID
	 */
	private String messageId;
}