package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars implements Model{

    List<Car> cars = new ArrayList<>();

    public RacingCars(String inputCars) throws IllegalArgumentException{
        validInputCars(inputCars);
        for(String carName : inputCars.split(",")) {
            validCarName(carName);
            this.cars.add(new Car(carName));
        }
    }

    private void validInputCars(String inputCars) {
        if(inputCars == null || inputCars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR]입력된 차량이 없습니다");
        }
    }

    private void validCarName(String carName) {
        if(carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR]차량 이름이 없는 차량이 있습니다");
        }
        if(carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR]차량 이름은 5자 이하만 가능합니다");
        }
    }

    public void race(){
        for(Car car : cars)
            car.drive();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
