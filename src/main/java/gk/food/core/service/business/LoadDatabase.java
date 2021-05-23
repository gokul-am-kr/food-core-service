package gk.food.core.service.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gk.food.core.service.entity.FoodEntity;
import gk.food.core.service.entity.FoodPriceEntity;
import gk.food.core.service.entity.PriceEntity;
import gk.food.core.service.entity.Tax;
import gk.food.core.service.entity.Taxes;
import gk.food.core.service.repository.FoodRepository;
import gk.food.core.service.utility.FoodCoreEnums;

/**
 * Configuration class for load data to H2 at the server start up.
 *
 */
@Configuration
class LoadDatabase {

	/**
	 * Loggr instance
	 */
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	/**
	 * Method for load data to the H
	 * 
	 * @param repository DB.
	 * 
	 * @return args.
	 */
	@Bean
	CommandLineRunner initDatabase(FoodRepository repository) {
		return args -> {
			// First food
			Taxes taxes1 = new Taxes(FoodCoreEnums.TaxCodes.GST, Long.valueOf(25), "INR");
			Taxes taxes2 = new Taxes(FoodCoreEnums.TaxCodes.CGST, Long.valueOf(30), "INR");
			List<Taxes> taxList = new ArrayList<>();
			taxList.add(taxes2);
			taxList.add(taxes1);
			Tax tax = new Tax(Long.valueOf(55), taxList, "INR");
			PriceEntity priceEntity = new PriceEntity(Long.valueOf(355), "INR", tax);
			FoodPriceEntity foodPrice = new FoodPriceEntity(Long.valueOf(355), "INR", priceEntity);
			FoodEntity food = new FoodEntity("FD001", "Burger", FoodCoreEnums.FoodType.NONVEG,
			        "Finger licking good burger seasoned with tender chicken.", 50, foodPrice);
			// Second food
			Taxes taxes3 = new Taxes(FoodCoreEnums.TaxCodes.GST, Long.valueOf(30), "INR");
			Taxes taxes4 = new Taxes(FoodCoreEnums.TaxCodes.CGST, Long.valueOf(35), "INR");
			List<Taxes> taxList1 = new ArrayList<>();
			taxList1.add(taxes3);
			taxList1.add(taxes4);
			Tax tax1 = new Tax(Long.valueOf(65), taxList1, "INR");
			PriceEntity priceEntity1 = new PriceEntity(Long.valueOf(565), "INR", tax1);
			FoodPriceEntity foodPrice1 = new FoodPriceEntity(Long.valueOf(565), "INR", priceEntity1);
			FoodEntity food1 = new FoodEntity("FD002", "Pizza", FoodCoreEnums.FoodType.NONVEG,
			        "Thin crust pizza seasoned with chekcn sausages.", 50, foodPrice1);
			// Third food
			Taxes taxes5 = new Taxes(FoodCoreEnums.TaxCodes.GST, Long.valueOf(20), "INR");
			Taxes taxes6 = new Taxes(FoodCoreEnums.TaxCodes.CGST, Long.valueOf(10), "INR");
			List<Taxes> taxList2 = new ArrayList<>();
			taxList2.add(taxes5);
			taxList2.add(taxes6);
			Tax tax2 = new Tax(Long.valueOf(30), taxList2, "INR");
			PriceEntity priceEntity2 = new PriceEntity(Long.valueOf(130), "INR", tax2);
			FoodPriceEntity foodPrice2 = new FoodPriceEntity(Long.valueOf(130), "INR", priceEntity2);
			FoodEntity food2 = new FoodEntity("FD003", "Veg Kuruma", FoodCoreEnums.FoodType.VEG,
			        "Thick vegitable kuruma", 50, foodPrice2);
			// Fourth food
			Taxes taxes7 = new Taxes(FoodCoreEnums.TaxCodes.GST, Long.valueOf(20), "INR");
			Taxes taxes8 = new Taxes(FoodCoreEnums.TaxCodes.CGST, Long.valueOf(20), "INR");
			List<Taxes> taxList3 = new ArrayList<>();
			taxList3.add(taxes7);
			taxList3.add(taxes8);
			Tax tax3 = new Tax(Long.valueOf(50), taxList3, "INR");
			PriceEntity priceEntity3 = new PriceEntity(Long.valueOf(200), "INR", tax3);
			FoodPriceEntity foodPrice3 = new FoodPriceEntity(Long.valueOf(200), "INR", priceEntity3);
			FoodEntity food3 = new FoodEntity("FD004", "Chilly chicken", FoodCoreEnums.FoodType.NONVEG,
			        "Chilli chicken", 50, foodPrice3);
			// Fifth list
			Taxes taxes9 = new Taxes(FoodCoreEnums.TaxCodes.GST, Long.valueOf(1), "INR");
			Taxes taxes0 = new Taxes(FoodCoreEnums.TaxCodes.CGST, Long.valueOf(1), "INR");
			List<Taxes> taxList4 = new ArrayList<>();
			taxList4.add(taxes9);
			taxList4.add(taxes0);
			Tax tax4 = new Tax(Long.valueOf(2), taxList4, "INR");
			PriceEntity priceEntity4 = new PriceEntity(Long.valueOf(6), "INR", tax4);
			FoodPriceEntity foodPrice4 = new FoodPriceEntity(Long.valueOf(6), "INR", priceEntity4);
			FoodEntity food4 = new FoodEntity("FD005", "Chapathi", FoodCoreEnums.FoodType.VEG, "Soft Chapathi", 50,
			        foodPrice4);
			log.info("Preloading " + repository.save(food));
			log.info("Preloading " + repository.save(food1));
			log.info("Preloading " + repository.save(food2));
			log.info("Preloading " + repository.save(food3));
			log.info("Preloading " + repository.save(food4));
		};
	}
}