package gk.food.core.service.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Entity class for store food price related details.
 *
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class FoodPriceEntity {

	/**
	 * Auto generated Price id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priceId;

	/**
	 * Total price of the food
	 */
	@NonNull
	private Long foodTotalPrice;

	/**
	 * Currency code
	 */
	@NonNull
	private String currencyCode;

	/**
	 * Price details of the food.
	 */
	@NonNull
	@OneToOne(targetEntity = PriceEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id", referencedColumnName = "id")
	private PriceEntity priceDetails;

}