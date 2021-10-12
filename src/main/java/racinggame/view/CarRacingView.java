package racinggame.view;

import java.util.List;
import racinggame.model.Car;
import racinggame.model.RacingCars;

public class CarRacingView implements View {

    private RacingCars racingCars;

    public CarRacingView(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    @Override
    public void output() {
        List<Car> cars = racingCars.getCars();
        for(Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        String carOutput = car.getCarName() + " : ";
        for(int i=0; i< car.getPosition(); i++) {
            carOutput += "-";
        }
        System.out.println(carOutput);
    }
}
