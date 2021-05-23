package gk.food.core.service.utility;

/**
 * Interface for holding ENUMS related with food core service.
 *
 */
public interface FoodCoreEnums {
	
	/**
	 * ENUM declaration for food type.
	 *
	 */
	enum FoodType{
		VEG,NONVEG,ALL;
	}

	/**
	 * ENUM declaration for tax code.
	 *
	 */
	enum TaxCodes{
		GST,CGST;
	}
	
	/**
	 * ENUM declaration for message type.
	 *
	 */
	enum MessageType{
		ERROR,INFO,WARN;
	}
}