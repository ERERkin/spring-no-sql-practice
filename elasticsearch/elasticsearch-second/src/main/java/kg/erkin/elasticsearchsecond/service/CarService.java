package kg.erkin.elasticsearchsecond.service;

import kg.erkin.elasticsearchsecond.dto.Car;
import kg.erkin.elasticsearchsecond.exception.NoSuchItemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car(1L, "Test1", 2000));
        cars.add(new Car(2L, "Test2", 2005));
        cars.add(new Car(3L, "Test3", 2010));
    }

    public Car getById(Long id){
        log.info("Try to found car with id {}", id);
        Car car = cars.stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoSuchItemException(id));
        log.info("Found car {}", car);
        return car;
    }
}
