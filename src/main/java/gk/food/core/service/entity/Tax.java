package gk.food.core.service.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Tax entity.
 *
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Tax {

	/**
	 * Auto generated unique ID in tax table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Tax amount.
	 */
	@NonNull
	private Long taxAmount;

	/**
	 * Tax list
	 */
	@OneToMany(targetEntity = Taxes.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "taxes_id", referencedColumnName = "id")
	@NonNull
	private List<Taxes> taxes;

	/**
	 * Currency code.
	 */
	@NonNull
	private String currencyCode;

}