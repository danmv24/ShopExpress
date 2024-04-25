package com.shop.inventoryservice;

import com.shop.inventoryservice.entity.InventoryEntity;
import com.shop.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			InventoryEntity inventory = new InventoryEntity();
			inventory.setProductId(2L);
			inventory.setQuantity(3);

			InventoryEntity inventory2 = new InventoryEntity();
			inventory.setProductId(3L);
			inventory.setQuantity(5);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
	}

}
