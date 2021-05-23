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
 * Price details related entity.
 *
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class PriceEntity {
	
	/**
	 * Auto generated unique ID in price table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Total food price.
	 */
	@NonNull
	private Long foodTotalPrice;

	/**
	 * Currency code.
	 */
	@NonNull
	private String currencyCode;

	/**
	 * Tax details of the food.
	 */
	@NonNull
	@OneToOne(targetEntity = Tax.class,cascade = CascadeType.ALL)
	@JoinColumn(name="tax_id",referencedColumnName = "id")
	private Tax tax;

}
