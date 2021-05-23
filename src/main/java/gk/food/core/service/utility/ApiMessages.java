package gk.food.core.service.utility;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * API messages class.
 *
 */
public class ApiMessages {

	private static final ReloadableResourceBundleMessageSource messageSource;

	static {
		messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
	}

	/**
	 * Message
	 */
	private String message;

	/**
	 * Message ID
	 */
	private String messageId;

	/**
	 * Getter for message.
	 * 
	 * @return message Message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter for message.
	 * 
	 * @return messageId Message ID.
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * Setter for message ID
	 * @param messageId Message ID.
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * API messages.
	 * 
	 * @param msgId
	 */
	protected ApiMessages(String msgId) {
		this.message = getMessage(msgId);
	}

	/**
	 * Method for get message from property file.
	 * 
	 * @param msgId Message ID.
	 * 
	 * @return Message string.
	 */
	public static String getMessage(String msgId) {
		return messageSource.getMessage(msgId, null, null);
	}

	/**
	 * Method for get message with arguments.
	 * 
	 * @param msgId Message ID.
	 * 
	 * @param parameters Array of parameters.
	 * 
	 * @return String message text.
	 */
	public static String getFormatMessage(String msgId, Object[] parameters) {
		return messageSource.getMessage(msgId, parameters, null);
	}

	/**
	 * Message for FCS001
	 */
	public static final ApiMessages FCS001 = new ApiMessages("FCS001");

	/**
	 * Message for FCS002
	 */
	public static final ApiMessages FCS002 = new ApiMessages("FCS002");

	/**
	 * Message for FCS003
	 */
	public static final ApiMessages FCS003 = new ApiMessages("FCS003");

	/**
	 * Message for FCS004
	 */
	public static final ApiMessages FCS004 = new ApiMessages("FCS004");

	/**
	 * Message for FCS005
	 */
	public static final ApiMessages FCS005 = new ApiMessages("FCS005");

	/**
	 * Message for FCS099
	 */
	public static final ApiMessages FCS099 = new ApiMessages("FCS099");

	/**
	 * Message for FCD001
	 */
	public static final ApiMessages FCD001 = new ApiMessages("FCD001");

	/**
	 * Message for FCD002
	 */
	public static final ApiMessages FCD002 = new ApiMessages("FCD002");

	/**
	 * Message for FCD003
	 */
	public static final ApiMessages FCD003 = new ApiMessages("FCD003");

	/**
	 * Message for FCD004
	 */
	public static final ApiMessages FCD004 = new ApiMessages("FCD004");

	/**
	 * Message for FCD005
	 */
	public static final ApiMessages FCD005 = new ApiMessages("FCD005");

	/**
	 * Message for FCD099
	 */
	public static final ApiMessages FCD099 = new ApiMessages("FCD099");

	/**
	 * Message for FCO001
	 */
	public static final ApiMessages FCO001 = new ApiMessages("FCO001");

	/**
	 * Message for FCO002
	 */
	public static final ApiMessages FCO002 = new ApiMessages("FCO002");

	/**
	 * Message for FCO003
	 */
	public static final ApiMessages FCO003 = new ApiMessages("FCO003");

	/**
	 * Message for FCO004
	 */
	public static final ApiMessages FCO004 = new ApiMessages("FCO004");

	/**
	 * Message for FCO005
	 */
	public static final ApiMessages FCO005 = new ApiMessages("FCO005");

	/**
	 * Message for FCO099
	 */
	public static final ApiMessages FCO099 = new ApiMessages("FCO099");
}