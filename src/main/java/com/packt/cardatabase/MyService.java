package com.packt.cardatabase;


import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {
    @Autowired
    private CarRepository carRepository;
    // create car objects
    @Autowired
    private OwnerRepository ownerRepository;

    Logger logger = LoggerFactory.getLogger(MyService.class);

    @Transactional(rollbackFor = RuntimeException.class)
    public void fetchCars() {
        // Add owner objects
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new  Owner("Mary" , "Robinson");
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

        // create car objects
        // owner1 : "John Johnson"
        Car car1 = new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2021, 59000);
        car1.setOwner(owner1);
        // owner2 : "Mary Robinson"
        Car car2 = new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2020, 29000);
        car2.setOwner(owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2020, 39000);
        car3.setOwner(owner2);
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        Optional<Car> myCar = carRepository.findById(2L);
        // you should check otherwise you may get NoSuchElementException
        if(myCar.isPresent()) {
            Car theCar = myCar.get();
            logger.info("Car Brand: " +  theCar.getBrand());
        } else {
            logger.warn("CAR not found!");
        }
        List<Car> carsByYear = carRepository.findByYear(2020);
        logger.info("car 2000 found: {}" , carsByYear.size());
        logger.info("owner first name: {}" , carsByYear.get(0).getOwner().getFirstname());
     //   throw new RuntimeException();
    }
}
