package racinggame.model;

import nextstep.utils.Randoms;

public class Car implements Model{

    private String carName;
    private int position = 0;

    public Car(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void drive(){
        if(Randoms.pickNumberInRange(0, 9) >= 4)
            position++;
    }
}
