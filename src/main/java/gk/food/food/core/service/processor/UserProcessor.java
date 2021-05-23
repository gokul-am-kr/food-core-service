package gk.food.food.core.service.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import gk.food.core.service.model.UserModel;

/**
 * Processor class for user details.
 *
 */
@Component
public class UserProcessor {

	/**
	 * Instance of Rest template
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Method for fetch user details.
	 * 
	 * @param userModel User model.
	 * 
	 * @return boolean status of user logn
	 */
	public boolean userLogin(UserModel userModel) {
		ResponseEntity<Boolean> loginStatus = restTemplate.postForEntity("http://localhost:8081/user/userLogin",
		        userModel, Boolean.class);
		return loginStatus.getBody();
	}
}