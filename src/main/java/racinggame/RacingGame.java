package racinggame;

import nextstep.utils.Console;
import racinggame.controller.CarRacingController;
import racinggame.controller.CarRacingPrizeController;
import racinggame.controller.MsgCarRacingController;
import racinggame.controller.MsgInputCarsController;
import racinggame.controller.MsgInputTryCountController;
import racinggame.model.RacingCars;
import racinggame.model.TryCount;

public class RacingGame {

    private RacingCars racingCars;
    private TryCount tryCount;

    public void play(){
        stepRacingCars();
        stepTryCount();
        stepCarRacing();
        stepPrize();
    }

    private void stepRacingCars() {
        printMsgInputCars();
        inputRacingCars();
    }

    private void stepTryCount() {
        printMsgTryCount();
        inputTryCount();
    }

    private void stepCarRacing() {
        printMsgCarRacing();
        carRacing();
    }

    private void stepPrize() {
        new CarRacingPrizeController().handle(racingCars).output();
    }

    private void inputTryCount() {
        do {
            try {
                tryCount = new TryCount(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } while (tryCount == null);
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

    private void carRacing() {
        int count = 0;
        CarRacingController carRacingController = new CarRacingController();
        do {
            carRacingController.handle(racingCars).output();
        } while (++count < tryCount.getTryCount());
    }

    private void printMsgCarRacing() {
        new MsgCarRacingController().handle().output();
    }

    private void printMsgInputCars(){
        new MsgInputCarsController().handle().output();
    }

    private void printMsgTryCount() {
        new MsgInputTryCountController().handle().output();
    }
}
