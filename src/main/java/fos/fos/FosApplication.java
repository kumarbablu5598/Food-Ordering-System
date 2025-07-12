package fos.fos;

import fos.fos.pojo.PlaceOrderRequest;
import fos.fos.pojo.PlaceOrderResponse;
import fos.fos.service.OrderService;
import fos.fos.service.RestaurantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class FosApplication {
	public static void main(String[] args) {
		SpringApplication.run(FosApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RestaurantService restaurantService, OrderService orderService) {
		return args -> {
			restaurantService.onboardRestaurant("R1", 4.5, 5, Map.of("Veg Biryani", 100, "Chicken Biryani", 150));
			restaurantService.onboardRestaurant("R2", 4.0, 5, Map.of("Idli", 10, "Dosa", 50, "Veg Biryani", 80, "Chicken Biryani", 175));
			restaurantService.onboardRestaurant("R3", 4.9, 1, Map.of("Idli", 15, "Dosa", 30, "Gobi Manchurian", 150, "Chicken Biryani", 175));
			restaurantService.updateMenu("R1", Map.of("Chicken65", 250));
			restaurantService.updateMenu("R2", Map.of("Chicken Biryani", 150));

			PlaceOrderResponse r1 = orderService.placeOrder(new PlaceOrderRequest("Ashwin", Map.of("Idli", 3, "Dosa", 1), "LOWEST_COST"));
			System.out.println("Order 1: " + r1.getMessage() + " → " + r1.getAssignedRestaurant());
			PlaceOrderResponse r2 = orderService.placeOrder(new PlaceOrderRequest("Harish", Map.of("Idli", 3, "Dosa", 1), "LOWEST_COST"));
			System.out.println("Order 2: " + r2.getMessage() + " → " + r2.getAssignedRestaurant());
			PlaceOrderResponse r3 = orderService.placeOrder(new PlaceOrderRequest("Shruthi", Map.of("Veg Biryani", 3, "Dosa", 1), "HIGHEST_RATING"));
			System.out.println("Order 3: " + r3.getMessage() + " → " + r3.getAssignedRestaurant());
			System.out.println(orderService.completeOrder(r1.getOrderId()));
			PlaceOrderResponse r4 = orderService.placeOrder(new PlaceOrderRequest("Harish", Map.of("Idli", 3, "Dosa", 1), "LOWEST_COST"));
			System.out.println("Order 4: " + r4.getMessage() + " → " + r4.getAssignedRestaurant());
			PlaceOrderResponse r5 = orderService.placeOrder(new PlaceOrderRequest("Diya", Map.of("Idli", 3, "Paneer Tikka", 1), "LOWEST_COST"));
			System.out.println("Order 5: " + r5.getMessage());
		};
	}
}
