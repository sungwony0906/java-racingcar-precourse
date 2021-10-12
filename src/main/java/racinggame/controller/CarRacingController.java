package racinggame.controller;

import racinggame.model.Model;
import racinggame.model.RacingCars;
import racinggame.view.CarRacingView;
import racinggame.view.View;

public class CarRacingController implements Controller{

    @Override
    public View handle(Model model) {
        RacingCars racingCars = (RacingCars) model;
        racingCars.race();
        return new CarRacingView(racingCars);
    }
}
