package cafe.shop.testing.cafe.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enable scheduling
public class CafeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeShopApplication.class, args);
	}

}
