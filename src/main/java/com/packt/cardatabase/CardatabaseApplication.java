package com.packt.cardatabase;

import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.io.File;

@SpringBootApplication
public class CardatabaseApplication  implements CommandLineRunner {

	@Value("${max.counter:4}")
	private int maxCounter;

	@Resource
	private File currentFolder;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		// After adding this comment the application is restarted
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Autowired
	MyService myService;

	@Override
	public void run(String... args) throws Exception {
		logger.info("command runner is started: " + maxCounter);
		logger.info("current folder: " + currentFolder.getAbsolutePath());
		try {
			myService.fetchCars();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
