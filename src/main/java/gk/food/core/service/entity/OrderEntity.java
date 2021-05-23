package gk.food.core.service.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entity class related with Food Booking.
 *
 */
@Entity
@Data
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID orderId;
	
	private String foodIds;
	
	private LocalDateTime orderedDateTime;
	
	private String userId;
}
