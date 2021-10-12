package racinggame.controller;

import racinggame.model.Model;
import racinggame.model.RacingCars;
import racinggame.view.CarRacingPrizeView;
import racinggame.view.View;

public class CarRacingPrizeController implements Controller{

    @Override
    public View handle(Model model) {
        RacingCars racingCars = (RacingCars) model;
        return new CarRacingPrizeView(racingCars);
    }
}
