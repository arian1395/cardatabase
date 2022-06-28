package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication  implements CommandLineRunner {

	@Value("${max.counter:4}")
	private int maxCounter;

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		// After adding this comment the application is restarted
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("command runner is started: " + maxCounter);
		// Add owner objects
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new  Owner("Mary" , "Robinson");

		// create car objects
		// owner1 : "John Johnson"
		Car car1 = new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2021, 59000);
		car1.setOwner(owner1);
		// owner2 : "Mary Robinson"
		Car car2 = new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2019, 29000);
		car2.setOwner(owner2);
		Car car3 = new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2020, 39000);
		car3.setOwner(owner2);
	}
}
