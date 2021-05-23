package gk.food.core.service.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import gk.food.core.service.utility.FoodCoreEnums.FoodType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Entity class related with food and its details.
 *
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class FoodEntity {

	/**
	 * Auto generated unique value for Food item in the table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Unique value for Food item in the table.
	 */
	@NonNull
	private String foodId;

	/**
	 * Food name.
	 */
	@NonNull
	private String foodName;

	/**
	 * Food type VEG/NON_VEG.
	 */
	@NonNull
	private FoodType foodType;

	/**
	 * Food description.
	 */
	@NonNull
	private String foodDescription;

	/**
	 * Quantity of food.
	 */
	@NonNull
	private Integer quantity;

	/**
	 * Price details of food.
	 */
	@NonNull
	@OneToOne(targetEntity = FoodPriceEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "map_id", referencedColumnName = "priceId")
	private FoodPriceEntity foodPrice;

}
