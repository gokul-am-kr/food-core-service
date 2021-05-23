package gk.food.core.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import gk.food.core.service.utility.FoodCoreEnums.TaxCodes;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;;

/**
 * Tax details entity.
 *
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Taxes {

	/**
	 * Auto generated unique id for tax details.
	 */
	@Id
	@GeneratedValue
	private int id;

	/**
	 * Tax code.
	 */
	@NonNull
	private TaxCodes taxCode;

	/**
	 * Tax price.
	 */
	@NonNull
	private Long taxPrice;

	/**
	 * Currency code.
	 */
	@NonNull
	private String currencyCode;

}
