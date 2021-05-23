package gk.food.core.service.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gk.food.core.service.entity.FoodEntity;
import gk.food.core.service.entity.OrderEntity;
import gk.food.core.service.model.FoodOrderRequest;
import gk.food.core.service.model.FoodOrderResponse;
import gk.food.core.service.model.Message;
import gk.food.core.service.model.UserModel;
import gk.food.core.service.repository.FoodRepository;
import gk.food.core.service.response.FoodOrderResponseInterpreter;
import gk.food.core.service.utility.ApiMessages;
import gk.food.core.service.utility.FoodCoreEnums;
import gk.food.food.core.service.processor.FoodOrderProcessor;
import gk.food.food.core.service.processor.UserProcessor;

/**
 * Service class related to food ordering.
 *
 */
@Service
public class FoodOrderService {

	/**
	 * Instance of FoodRepository
	 */
	@Autowired
	private FoodRepository foodRepository;

	/**
	 * Instance of FoodOrderProcessor
	 */
	@Autowired(required = false)
	private FoodOrderProcessor foodOrderProcessor;

	/**
	 * Instance of FoodOrderResponseInterpreter
	 */
	@Autowired
	private FoodOrderResponseInterpreter foodOrderResponseInterpreter;

	/**
	 * Instance of UserProcessor
	 */
	@Autowired
	private UserProcessor userProcessor;

	/**
	 * Method for order food.
	 * 
	 * @param foodOrderRequest Food order request.
	 * 
	 * @return response Food order response.
	 */
	public FoodOrderResponse orderFood(FoodOrderRequest foodOrderRequest) {
		FoodOrderResponse reponse = new FoodOrderResponse();
		UserModel usermodel = new UserModel();
		try {
			usermodel.setUserName(foodOrderRequest.getUserName());
			usermodel.setPassword(foodOrderRequest.getPassWord());
			if (userProcessor.userLogin(null)) {
				List<String> foodIds = foodOrderRequest.getFoodOrderList().stream().map(order -> order.getFoodId())
				        .collect(Collectors.toList());
				List<FoodEntity> foodEntityList = foodRepository.foodByIds(foodIds);
				if (foodEntityList.size() > 0) {
					OrderEntity entity = foodOrderProcessor.insertOrderToDd(foodOrderRequest, foodIds.toString());
					reponse.setOrderId(entity.getOrderId().toString());
					foodOrderRequest.getFoodOrderList().stream().forEach(
					        food -> foodRepository.updateProductQuantity(food.getQuantity(), food.getFoodId()));
				}
				foodOrderResponseInterpreter.buildOrderResponse(foodEntityList, foodOrderRequest, reponse);
			} else {
				Message message = new Message();
				message.setMessageId(ApiMessages.FCO001.getMessageId());
				message.setMessage(ApiMessages.FCO001.getMessage());
				message.setMessageType(FoodCoreEnums.MessageType.ERROR);
				reponse.setMessage(message);
			}
		} catch (Exception exception) {
			Message message = new Message();
			message.setMessageId(ApiMessages.FCO099.getMessageId());
			message.setMessage(ApiMessages.FCO099.getMessage());
			message.setMessageType(FoodCoreEnums.MessageType.ERROR);
			reponse.setMessage(message);
		}
		return reponse;
	}
}