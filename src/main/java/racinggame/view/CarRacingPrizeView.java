package racinggame.view;

import java.util.List;
import racinggame.model.Car;
import racinggame.model.RacingCars;
import racinggame.view.View;

public class CarRacingPrizeView implements View {

    private RacingCars racingCars;

    public CarRacingPrizeView(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    @Override
    public void output() {
        List<Car> winner = racingCars.getWinner();
        String msg = "최종 우승자는 ";
        for (Car car : winner) {
            msg += car.getCarName() + ",";
        }
        System.out.println(msg.substring(0, msg.length()-1) + " 입니다.");
    }
}
