package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private final List<Car> carList;
    {
        carList = new ArrayList<>();
        carList.add(new Car("Mitsubishi", "Pajero", 300));
        carList.add(new Car("Toyota", "Corolla", 200));
        carList.add(new Car("Huyndai", "Solaris", 250));
        carList.add(new Car("Honda", "Accord", 270));
        carList.add(new Car("Nissan", "Almera", 230));

    }
    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
