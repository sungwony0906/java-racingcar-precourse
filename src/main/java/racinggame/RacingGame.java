package racinggame;

import nextstep.utils.Console;
import racinggame.controller.MsgInputCarsController;
import racinggame.model.RacingCars;

public class RacingGame {

    private RacingCars racingCars;

    public void startGame(){
        msgInputCars();
        inputRacingCars();
    }

    private void inputRacingCars() {
        do {
            try {
                racingCars = new RacingCars(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } while (racingCars == null);
    }

    private void msgInputCars(){
        new MsgInputCarsController().handle().output();
    }
}
